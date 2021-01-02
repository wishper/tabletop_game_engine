package briscola;

import game_engine.Player;
import game_engine.standard_cards.ItalianCard;
import game_engine.standard_cards.ItalianCard.Seme;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Mano extends LinkedList<AzioneDellaMano>{
	private final Seme briscola;

	public Mano(Seme briscola) {
		this.briscola = briscola;
	}

	public RisultatoMano risolvi() {
		int punteggioMano = 0;
		ItalianCard valoreVincente = get(0).getCarta();
		Player giocatoreVincente = get(0).getGiocatore();

		for (AzioneDellaMano turnAction: this) {
			punteggioMano += BriscolaEngine.punteggioDellaCarta(turnAction.getCarta());
			if(laSecondaVince(valoreVincente, turnAction.getCarta())) {
				valoreVincente = turnAction.getCarta();
				giocatoreVincente = turnAction.getGiocatore();
			};
		}
		return new RisultatoMano(giocatoreVincente, punteggioMano);
	}

	public boolean laSecondaVince(ItalianCard o1, ItalianCard o2){
		if(o2.getSeme()==briscola) {
			if(o1.getSeme()==briscola) {
				return BriscolaEngine.forzaDellaCarta(o2)>BriscolaEngine.forzaDellaCarta(o1);
			}
			else {
				return true;
			}
		}
		if(o2.getSeme() != o1.getSeme()) {
			return false; //non risponde al seme, niente briscola
		}
		//o2 non gioca briscola ma rsponde al seme, vince il piu alto
		return BriscolaEngine.forzaDellaCarta(o2)>BriscolaEngine.forzaDellaCarta(o1);
	}
}
