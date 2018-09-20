package principal;

import processing.core.PApplet;

import de.fhpotsdam.unfolding.UnfoldingMap;

import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.mapdisplay.MapDisplayFactory;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.providers.OpenStreetMap.OpenStreetMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;

/**
 * Simple map app showing how to convert screen position to geo-location, and vice versa.
 * 
 * For automatic conversion from geo-location to screen, take a look at Unfolding's marker mechanism.
 * Start at {@link SimpleMarkeApp} and {@link SimpleMarkerManagerApp}.
 */
public class LocalizacaoPrefeiturasBairro extends PApplet {

	UnfoldingMap map1;
	UnfoldingMap map2;
	UnfoldingMap map3;
	UnfoldingMap map4;
	UnfoldingMap currentMap;
	
	public void setup() {
		size(1800, 1600, OPENGL);

		map1 = new UnfoldingMap(this, new OpenStreetMapProvider());
		map2 = new UnfoldingMap(this, new Google.GoogleMapProvider());//teste provider
	    map3 = new UnfoldingMap(this, new Microsoft.AerialProvider());//teste provider
	    map4 = new UnfoldingMap(this, new OpenStreetMap.CloudmadeProvider(MapDisplayFactory.OSM_API_KEY, 230588));//teste provider
	    map1.zoomAndPanTo(12, new Location(-12.99f, -38.5f));
	    map2.zoomAndPanTo(12, new Location(-12.9f, -38.5f));//teste provider
	    map3.zoomAndPanTo(12, new Location(-12.9f, -38.5f));//teste provider
	    map4.zoomAndPanTo(12, new Location(-12.9f, -38.5f));//teste provider
		MapUtils.createDefaultEventDispatcher(this, map1, map2, map3);
		//Chose font of Map
		currentMap = map1; //Provider utilizado
	}

	public void draw() {
		currentMap.draw();
		fill(0, 255, 200, 255);

		// Centro
		Location centro = new Location(-12.974, -38.511);
		ScreenPosition pos1 = currentMap.getScreenPosition(centro);
		ellipse(pos1.x, pos1.y, 20, 20);

		String centroDescription = "Prefeitura Bairro Centro(" + (int) pos1.x + "," + (int) pos1.y + ")";
		text(centroDescription, pos1.x, pos1.y);
		
		// Suburbio/Ilhas
		Location suburbioIlhas = new Location(-12.840, -38.466);
		ScreenPosition pos2 = currentMap.getScreenPosition(suburbioIlhas);
		ellipse(pos2.x, pos2.y, 20, 20);

		String suburbioIlhasDescription = "Prefeitura Bairro Suburbio/Ilhas(" + (int) pos2.x + "," + (int) pos2.y + ")";
		text(suburbioIlhasDescription, pos2.x, pos2.y);
		
		// Cajazeiras
		Location cajazeiras = new Location(-12.899, -38.412);
		ScreenPosition pos3 = currentMap.getScreenPosition(cajazeiras);
		ellipse(pos3.x, pos3.y, 20, 20);

		String cajazeirasDescription = "Prefeitura Bairro Cajazeiras(" + (int) pos3.x + "," + (int) pos3.y + ")";
		text(cajazeirasDescription, pos3.x, pos3.y);
		
		// Itapua/Ipitanga
		Location itapuaIpitanga = new Location(-12.938336, -38.361809);
		ScreenPosition pos4 = currentMap.getScreenPosition(itapuaIpitanga);
		ellipse(pos4.x, pos4.y, 20, 20);

		String itapuaIpitangaDescription = "Prefeitura Bairro Itapua/Ipitanga(" + (int) pos4.x + "," + (int) pos4.y + ")";
		text(itapuaIpitangaDescription, pos4.x, pos4.y);

		// Cidade Baixa
		Location cidadeBaixa = new Location(-12.918, -38.499);
		ScreenPosition pos5 = currentMap.getScreenPosition(cidadeBaixa);
		ellipse(pos5.x, pos5.y, 20, 20);

		String cidadeBaixaDescription = "Prefeitura Bairro Cidade Baixa(" + (int) pos5.x + "," + (int) pos5.y + ")";
		text(cidadeBaixaDescription, pos5.x, pos5.y);
		
		// Barra/Pituba
		Location barraPituba = new Location(-13.013, -38.483);
		ScreenPosition pos6 = currentMap.getScreenPosition(barraPituba);
		ellipse(pos6.x, pos6.y, 20, 20);

		String barraPitubaDescription = "Prefeitura Bairro Barra/Pituba(" + (int) pos6.x + "," + (int) pos6.y + ")";
		text(barraPitubaDescription, pos6.x, pos6.y);
		
		// Liberdade/São Caetano
		Location liberdadeSaoCaetano = new Location(-12.945, -38.483);
		ScreenPosition pos7 = currentMap.getScreenPosition(liberdadeSaoCaetano);
		ellipse(pos7.x, pos7.y, 20, 20);

		String liberdadeSaoCaetanoDescription = "Prefeitura Bairro Liberdade/São Caetano(" + (int) pos7.x + "," + (int) pos7.y + ")";
		text(liberdadeSaoCaetanoDescription, pos7.x, pos7.y);
		
		// Cabula/Tancredo Neves
		Location cabulaTancredoNeves = new Location(-12.959, -38.467);
		ScreenPosition pos8 = currentMap.getScreenPosition(cabulaTancredoNeves);
		ellipse(pos8.x, pos8.y, 20, 20);

		String cabulaTancredoNevesDescription = "Prefeitura Bairro Cabula/Tancredo Neves(" + (int) pos8.x + "," + (int) pos8.y + ")";
		text(cabulaTancredoNevesDescription, pos8.x, pos8.y);

		// Pau da Lima
		Location paudaLima = new Location(-12.927, -38.432);
		ScreenPosition pos9 = currentMap.getScreenPosition(paudaLima);
		ellipse(pos9.x, pos9.y, 20, 20);

		String paudaLimaDescription = "Prefeitura Bairro Pau da Lima(" + (int) pos9.x + "," + (int) pos9.y + ")";
		text(paudaLimaDescription, pos9.x, pos9.y);
		
		// Valeria
		Location valeria = new Location(-12.870, -38.433);
		ScreenPosition pos10 = currentMap.getScreenPosition(valeria);
		ellipse(pos10.x, pos10.y, 20, 20);

		String valeriaDescription = "Prefeitura Bairro Valeria(" + (int) pos10.x + "," + (int) pos10.y + ")";
		text(valeriaDescription, pos10.x, pos10.y);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "principal.SimplePositionMap" });	
	}
}