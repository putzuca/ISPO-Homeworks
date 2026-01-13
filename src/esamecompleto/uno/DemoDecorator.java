package esamecompleto.uno;

//Component: interfaccia comune a componente base e decorator
interface Messaggio {
 String testo();
}

//ConcreteComponent: implementazione base
class MessaggioBase implements Messaggio {
 final String contenuto;

 MessaggioBase(String contenuto) {
     this.contenuto = contenuto;
 }

 @Override
 public String testo() {
     return contenuto;
 }
}

//Decorator: implementa la stessa interfaccia e contiene un riferimento al Component decorato
abstract class MessaggioDecorator implements Messaggio {
 final Messaggio inner;

 MessaggioDecorator(Messaggio inner) {
     this.inner = inner;
 }
}

//ConcreteDecorator: aggiunge comportamento (parentesi) delegando a inner
class ParentesiDecorator extends MessaggioDecorator {
 ParentesiDecorator(Messaggio inner) {
     super(inner);
 }

 @Override
 public String testo() {
     return "(" + inner.testo() + ")";
 }
}

//ConcreteDecorator: aggiunge comportamento (duplicazione) delegando a inner
class DuplicaDecorator extends MessaggioDecorator {
 DuplicaDecorator(Messaggio inner) {
     super(inner);
 }

 @Override
 public String testo() {
     String s = inner.testo();
     return s + s;
 }
}

//Client: compone dinamicamente i decorator e usa sempre l'interfaccia Messaggio
public class DemoDecorator {
 public static void main(String[] args) {
     Messaggio base = new MessaggioBase("ciao");

     // Ordine 1: prima duplica, poi mette tra parentesi
     Messaggio m1 = new ParentesiDecorator(new DuplicaDecorator(base));
     System.out.println(m1.testo()); // (ciaociao)

     // Ordine 2: prima mette tra parentesi, poi duplica
     Messaggio m2 = new DuplicaDecorator(new ParentesiDecorator(base));
     System.out.println(m2.testo()); // (ciao)(ciao)
 }
}
