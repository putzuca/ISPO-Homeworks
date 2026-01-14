package battlefield.d3;

import java.util.*;

public class Battlefield {

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;

	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;

	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%

	private int dim;

	private Random random;
	
	private Map<Position, Robot> posizione2robot;

	public Battlefield(int dimensione) {
		this.dim = dimensione;
		this.posizione2robot = new HashMap<>();
		this.random = new Random();
	}
	
	/* Aggiunge alla mappa un robot:
	 * - Walker: solo se la posizione è libera
	 * - Chaser: se la posizione è libera (a inizio gioco) o se rimpiazza un Walker (invasione) */
	public void addRobot(Robot r) {
		Position p = r.getPosizione();
		Robot presente = this.posizione2robot.get(p);

	    boolean invasioneConsentita = (r instanceof Chaser) && (presente instanceof Walker);

	    if (isLibera(p) || invasioneConsentita) {
	        this.posizione2robot.put(p, r);
	    }
	}
		
	// Aggiunge un Walker (delega a addRobot)
	public void addWalker(Walker w) { addRobot(w); }
	
	// Aggiunge un Chaser (delega a addRobot)
	public void addChaser(Chaser c) { addRobot(c); }

	public Robot getRobot(Position p) {
	    return this.posizione2robot.get(p);
	}

	public Walker getWalker(Position p) {
	    Robot r = getRobot(p);
	    if (r instanceof Walker) {
	        return (Walker) r;
	    } else {
	        return null;
	    }
	}

	public Chaser getChaser(Position p) {
	    Robot r = getRobot(p);
	    if (r instanceof Chaser) {
	        return (Chaser) r;
	    } else {
	        return null;
	    }
	}
	
	public Collection<Robot> getAllRobots() {
		return this.posizione2robot.values();
	}

	public Collection<Walker> getAllWalkers() {
		Collection<Walker> l = new ArrayList<Walker>();
		for(Robot r : this.getAllRobots()) {
			if (r instanceof Walker) {
				l.add((Walker) r);
			}
		}
		return l;
	}

	public Collection<Chaser> getAllChasers() {
		Collection<Chaser> l = new ArrayList<Chaser>();
		for(Robot r : this.getAllRobots()) {
			if (r instanceof Chaser) {
				l.add((Chaser) r);
			}
		}
		return l;
	}

	@SuppressWarnings("rawtypes")
	public Map<Class, Set<Robot>> raggruppaRobotPerTipo() {
		// (vedi DOMANDA 3)
		Set<Robot> tmp;
		Map<Class, Set<Robot>> mappa = new HashMap<Class, Set<Robot>>();
		
		for(Robot r : this.getAllRobots()) {
			tmp = mappa.get(r.getClass());
			if (tmp == null)
				tmp = new HashSet<Robot>();
			tmp.add(r);
			mappa.put(r.getClass(), tmp);
		}
		return mappa;
	}
	
	public List<?> getRobotOrdinatiPerPosizione() {
		// (vedi DOMANDA 4)
		return null;
	}
	
	public SortedSet<?> getRobotOrdinatiPerLongevita() {
		// (vedi DOMANDA 6)
		return null;
	}
	
	public List<Position> adiacenti(Position perno) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = perno.getX();
		int y = perno.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				Position adiacente = new Position(x+i, y+j);
				if (inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(perno);  // coincidono: quindi non sono adiacenti
		
		Collections.shuffle(adiacenti); /* ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return  p.getX()>=0 && p.getX()<this.dim && 
				p.getY()>=0 && p.getY()<this.dim  ;
				
	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return !posizione2robot.containsKey(posizione);
	}

	public int getDimensione() {
		return this.dim;
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dim * dim);
		for(int i=0 ; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dim);
			int y = this.random.nextInt(this.dim);
			Position posizione = new Position(x, y);
			if (this.isLibera(posizione)) {
				switch (this.random.nextInt(NUMERO_TIPOLOGIE)) {
				case 0: Chaser chaser = new Chaser(posizione);
						this.addChaser(chaser);
				break;
				case 1: Walker walker = new Walker(posizione);
						this.addWalker(walker);
				break;
				//case: NUMERO_TIPOLOGIE-1...
				default: throw new IllegalStateException();
				} 
			}
		}
	}

}
