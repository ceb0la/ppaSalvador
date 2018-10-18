package principal;

import java.util.HashMap;
import java.util.List;

import processing.core.PApplet;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap.OpenStreetMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * Visualizes population density of the world as a choropleth map. Countries are shaded in proportion to the population
 * density.
 * 
 * It loads the country shapes from a GeoJSON file via a data reader, and loads the population density values from
 * another CSV file (provided by the World Bank). The data value is encoded to transparency via a simplistic linear
 * mapping.
 * ChoroplethMapApp
 */
public class MapaCalorPopulacional extends PApplet {

	UnfoldingMap map;

	HashMap<String, DataEntry> dataEntriesMap;
	List<Marker> countryMarkers;

	public void setup() {
		size(1300, 900, OPENGL);
		smooth();

		//map = new UnfoldingMap(this, 50, 50, 700, 500);
		map = new UnfoldingMap(this, new OpenStreetMapProvider());
		map.zoomToLevel(2);
		map.zoomAndPanTo(12, new Location(-12.89f, -38.5f));
		map.setBackgroundColor(240);
		MapUtils.createDefaultEventDispatcher(this, map);

		// Load country polygons and adds them as markers
		List<Feature> countries = GeoJSONReader.loadData(this, "data/salvador.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);

		// Load population data
		dataEntriesMap = loadPopulationDensityFromCSV("data/populacao.csv");
		println("Loaded " + dataEntriesMap.size() + " data entries");

		// Country markers are shaded according to its population density (only once)
		shadeArea();
	}

	public void draw() {
		background(240);
		 
		// Draw map tiles and country markers
		map.draw();
		
		//Map Title
		String title ="Calor Populacional por Prefeitura Bairro";
		textSize(32);
		fill(255, 255, 255, 500);
		text(title, (width/2)-100, height-10);
	}

	public void shadeArea() {
		for (Marker marker : countryMarkers) {
			// Find data for country of the current marker
			String placeId = marker.getId();
			System.out.println("Id do Json: "+placeId);
			DataEntry dataEntry = dataEntriesMap.get(placeId);
			System.out.println("Id do arquivo: "+dataEntry.place);
			
			if (dataEntry != null && dataEntry.value != null) {
				// Encode value as brightness (values range: 0-1000)
				float transparency = map(dataEntry.value, 0, 700, 10, 255);
				marker.setColor(color(244, 98, 80, transparency));
			} else {
				// No value available
				marker.setColor(color(100, 120));
			}
		}
	}

	public HashMap<String, DataEntry> loadPopulationDensityFromCSV(String fileName) {
		HashMap<String, DataEntry> dataEntriesMap = new HashMap<String, DataEntry>();

		String[] rows = loadStrings(fileName);
		for (String row : rows) {
			// Reads country name and population density value from CSV row
			
			String[] columns = row.split(";");
			System.out.println("Quantidade de Colunas: "+ columns.length);
			if (columns.length >= 3) {
				DataEntry dataEntry = new DataEntry();
				dataEntry.place = columns[0];	//first column
				System.out.println("Pais do arquivo: "+ dataEntry.place);
				dataEntry.id = columns[1];	//Second column
				dataEntry.value = Float.parseFloat(columns[2]); 	//third column
				dataEntriesMap.put(dataEntry.id, dataEntry);
			}
		}

		return dataEntriesMap;
	}

	class DataEntry {
		String place;
		String id;
		Integer year;
		Float value;
	}
}
