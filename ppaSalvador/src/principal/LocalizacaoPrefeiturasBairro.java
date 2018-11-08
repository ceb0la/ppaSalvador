package principal;

import processing.core.PApplet;

import de.fhpotsdam.unfolding.UnfoldingMap;

import de.fhpotsdam.unfolding.geo.Location;
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

	UnfoldingMap map;
	UnfoldingMap currentMap;
	
	public void setup() {
		size(1800, 1600, OPENGL);

		map = new UnfoldingMap(this, new OpenStreetMapProvider());
	    map.zoomAndPanTo(12, new Location(-12.99f, -38.5f));
	    MapUtils.createDefaultEventDispatcher(this, map);
	    currentMap = map;
	}

	public void draw() {
		currentMap.draw();
		fill(255, 255, 200, 255);
		textSize(15);
		fill(0, 59, 72, 200);

		// Centro
		Location centro = new Location(-12.974, -38.511);
		ScreenPosition pos1 = currentMap.getScreenPosition(centro);
		ellipse(pos1.x, pos1.y, 15, 15);
			
		String centroDescription = "Prefeitura Bairro Centro" + (Location) centro;
		text(centroDescription, pos1.x, pos1.y);
		
		// Suburbio/Ilhas
		Location suburbioIlhas = new Location(-12.840, -38.466);
		ScreenPosition pos2 = currentMap.getScreenPosition(suburbioIlhas);
		ellipse(pos2.x, pos2.y, 15, 15);

		String suburbioIlhasDescription = "Prefeitura Bairro Suburbio/Ilhas" + (Location) suburbioIlhas ;
		text(suburbioIlhasDescription, pos2.x, pos2.y);
		
		// Cajazeiras
		Location cajazeiras = new Location(-12.899, -38.412);
		ScreenPosition pos3 = currentMap.getScreenPosition(cajazeiras);
		ellipse(pos3.x, pos3.y, 15, 15);

		String cajazeirasDescription = "Prefeitura Bairro Cajazeiras" + (Location) cajazeiras;
		text(cajazeirasDescription, pos3.x, pos3.y);
		
		// Itapua/Ipitanga
		Location itapuaIpitanga = new Location(-12.938336, -38.361809);
		ScreenPosition pos4 = currentMap.getScreenPosition(itapuaIpitanga);
		ellipse(pos4.x, pos4.y, 15, 15);

		String itapuaIpitangaDescription = "Prefeitura Bairro Itapua/Ipitanga" + (Location) itapuaIpitanga;
		text(itapuaIpitangaDescription, pos4.x, pos4.y);

		// Cidade Baixa
		Location cidadeBaixa = new Location(-12.918, -38.499);
		ScreenPosition pos5 = currentMap.getScreenPosition(cidadeBaixa);
		ellipse(pos5.x, pos5.y, 15, 15);

		String cidadeBaixaDescription = "Prefeitura Bairro Cidade Baixa" + (Location) cidadeBaixa;
		text(cidadeBaixaDescription, pos5.x, pos5.y);
		
		// Barra/Pituba
		Location barraPituba = new Location(-13.013, -38.483);
		ScreenPosition pos6 = currentMap.getScreenPosition(barraPituba);
		ellipse(pos6.x, pos6.y, 15, 15);

		String barraPitubaDescription = "Prefeitura Bairro Barra/Pituba" + (Location) barraPituba;
		text(barraPitubaDescription, pos6.x, pos6.y);
		
		// Liberdade/São Caetano
		Location liberdadeSaoCaetano = new Location(-12.945, -38.483);
		ScreenPosition pos7 = currentMap.getScreenPosition(liberdadeSaoCaetano);
		ellipse(pos7.x, pos7.y, 15, 15);

		String liberdadeSaoCaetanoDescription = "Prefeitura Bairro Liberdade/São Caetano" + (Location) liberdadeSaoCaetano;
		text(liberdadeSaoCaetanoDescription, pos7.x, pos7.y);
		
		// Cabula/Tancredo Neves
		Location cabulaTancredoNeves = new Location(-12.959, -38.467);
		ScreenPosition pos8 = currentMap.getScreenPosition(cabulaTancredoNeves);
		ellipse(pos8.x, pos8.y, 15, 15);

		String cabulaTancredoNevesDescription = "Prefeitura Bairro Cabula/Tancredo Neves" + (Location) cabulaTancredoNeves;
		text(cabulaTancredoNevesDescription, pos8.x, pos8.y);

		// Pau da Lima
		Location paudaLima = new Location(-12.927, -38.432);
		ScreenPosition pos9 = currentMap.getScreenPosition(paudaLima);
		ellipse(pos9.x, pos9.y, 15, 15);

		String paudaLimaDescription = "Prefeitura Bairro Pau da Lima"+ (Location) paudaLima;
		text(paudaLimaDescription, pos9.x, pos9.y);
		
		// Valeria
		Location valeria = new Location(-12.870, -38.433);
		ScreenPosition pos10 = currentMap.getScreenPosition(valeria);
		ellipse(pos10.x, pos10.y, 15, 15);

		String valeriaDescription = "Prefeitura Bairro Valeria" + (Location) valeria;
		text(valeriaDescription, pos10.x, pos10.y);
		
		String title ="População por Prefeitura Bairro";
		textSize(32);
		
		text(title, (width/2)-100, height-10);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "principal.SimplePositionMap" });	
	}
}