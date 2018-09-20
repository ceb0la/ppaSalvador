package principal;

import processing.core.PApplet;
import processing.core.PFont;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap.OpenStreetMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;

/**
 * Simple custom marker display, without the use of MarkerManager.
 * 
 * <p>
 * <em>Use only if you want to customize more than colors AND are not familiar with writing own classes.</em><br/>
 * If you want to only customize colors, use Unfolding's marker manager (see {@link SimpleMarkerManagerApp}).<br/>
 * If you want to have complete control, but also want to use the marker manager, write your own marker class (see {@link }).
 * </p> 
 * 
 * <p>
 * Here, conversion between geo-location and screen position is done via the marker, but drawing the markers is done by this
 * application itself. This is the easiest way of drawing own styled markers. A more advanced way is to create an own
 * Marker class with custom style, where all the position handling can be done via the internal marker mechanism. See
 * tutorials for an explanation of the differences.
 * </p>
 */
@SuppressWarnings("serial")
public class TesteMarcadorSimplesApp extends PApplet {

	UnfoldingMap map;

	SimplePointMarker markerCentro;
	SimplePointMarker markerSuburbioIlhas;
	SimplePointMarker markerCajazeiras;
	SimplePointMarker markerItapuaIpitanga;
	SimplePointMarker markerCidadeBaixa;
	SimplePointMarker markerBarraPituba;
	SimplePointMarker markerLiberdadeSaoCaetano;
	SimplePointMarker markerCabulaTancredoNeves;
	SimplePointMarker markerPaudaLima;
	SimplePointMarker markerValeria;

	public void setup() {
		size(1800, 900, OPENGL);
		smooth();

		map = new UnfoldingMap(this, new OpenStreetMapProvider());
		// map.setTweening(true);
		map.zoomToLevel(12);
		map.panTo(new Location(-12.890f, -38.5f));//-12.99f, -38.5f
		MapUtils.createDefaultEventDispatcher(this, map);

		// Create Markers from Locations
		Location locationCentro =new Location(-12.974, -38.511);
		Location locationSuburbioIlhas = new Location(-12.840, -38.466);
		Location locationCajazeiras = new Location(-12.899,	-38.412);
		Location locationItapuaIpitanga = new Location(-12.938, -38.361);
		
		markerCentro = new SimplePointMarker(locationCentro);				
		markerSuburbioIlhas = new SimplePointMarker(locationSuburbioIlhas);
		markerCajazeiras = new SimplePointMarker(locationCajazeiras);
		markerItapuaIpitanga = new SimplePointMarker(locationItapuaIpitanga);
		PFont font = createFont("serif-bold", 12);
		textFont(font);
	}

	public void draw() {
		background(70);

		map.draw();

		// Draws Markers on screen positions according to their geo-locations.
		//Centro
		ScreenPosition posCentro = markerCentro.getScreenPosition(map);
		strokeWeight(12);
		stroke(200, 0, 0, 200);
		strokeCap(SQUARE);
		noFill();
		// Zoom dependent marker size
		// float s = map.getZoom();
		float pf1 = 30;
		arc(posCentro.x, posCentro.y, pf1, pf1, -PI * 0.9f, -PI * 0.1f);
		arc(posCentro.x, posCentro.y, pf1, pf1, PI * 0.1f, PI * 0.9f);
		fill(0);
		text("Centro", posCentro.x - textWidth("Centro") / 2, posCentro.y + 4);
		
		//SuburbioIlhas
		ScreenPosition posSuburbioIlhas = markerSuburbioIlhas.getScreenPosition(map);
		strokeWeight(12);
		stroke(200, 0, 0, 200);
		strokeCap(SQUARE);
		noFill();
		// Zoom dependent marker size
		// float s = map.getZoom();
		float pf2 = 30;
		arc(posSuburbioIlhas.x, posSuburbioIlhas.y, pf2, pf2, -PI * 0.9f, -PI * 0.1f);
		arc(posSuburbioIlhas.x, posSuburbioIlhas.y, pf2, pf2, PI * 0.1f, PI * 0.9f);
		fill(0);
		text("Suburbio Ilhas", posSuburbioIlhas.x - textWidth("Suburbio Ilhas") / 2, posSuburbioIlhas.y + 4);
		
		//Cajazeiras
		ScreenPosition posCajazeiras = markerCajazeiras.getScreenPosition(map);
		strokeWeight(12);
		stroke(200, 0, 0, 200);
		strokeCap(SQUARE);
		noFill();
		// Zoom dependent marker size
		// float s = map.getZoom();
		float pf3 = 30;
		arc(posCajazeiras.x, posCajazeiras.y, pf3, pf3, -PI * 0.9f, -PI * 0.1f);
		arc(posCajazeiras.x, posCajazeiras.y, pf3, pf3, PI * 0.1f, PI * 0.9f);
		fill(0);
		text("Cajazeiras", posCajazeiras.x - textWidth("Cajazeiras") / 2, posCajazeiras.y + 4);
		
		//ItapuaIpitanga
		ScreenPosition posItapuaIpitanga = markerItapuaIpitanga.getScreenPosition(map);
		strokeWeight(12);
		stroke(200, 0, 0, 200);
		strokeCap(SQUARE);
		noFill();
		// Zoom dependent marker size
		// float s = map.getZoom();
		float pf4 = 30;
		arc(posItapuaIpitanga.x, posItapuaIpitanga.y, pf4, pf4, -PI * 0.9f, -PI * 0.1f);
		arc(posItapuaIpitanga.x, posItapuaIpitanga.y, pf4, pf4, PI * 0.1f, PI * 0.9f);
		fill(0);
		text("ItapuaIpitanga", posItapuaIpitanga.x - textWidth("ItapuaIpitanga") / 2, posItapuaIpitanga.y + 4);

	}
}