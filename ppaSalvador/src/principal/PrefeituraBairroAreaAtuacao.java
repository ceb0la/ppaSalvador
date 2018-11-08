package principal;

import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.OpenStreetMap.OpenStreetMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;
import processing.data.Table;

public class PrefeituraBairroAreaAtuacao extends PApplet{
	
	private static final long serialVersionUID = 1L;
	
	UnfoldingMap map;
	List<Marker> areaMarkers;
	//HashMap<String, DataEntry> dataEntriesMap;
	
	int[] style = {	color(1,22,39),
					color(119,63,76),
					color(46,196,182),
					color(231,29,54),
					color(255,159,28),
					color(166,204,146),
					color(154,86,255),
					color(75,196,45)
					};
	
	public void setup(){
		
		size(1800, 1600, OPENGL);
		map = new UnfoldingMap(this, new OpenStreetMapProvider());
		map.zoomAndPanTo(12, new Location(-12.99f, -38.5f));
		
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// Load polygons and adds them as markers
		List<Feature> prefBairro = GeoJSONReader.loadData(this, "data/salvador.geo.json");
		
		areaMarkers = MapUtils.createSimpleMarkers(prefBairro);
		map.addMarkers(areaMarkers);
		
		//areaMarkers.setColor(color(100, 120));
		//Marker marker = null;
		//marker.setColor(color(style[i]));
		//marker.setColor(color(style[i], transparency));
		
		// Load Markers data
		Table tabela = loadTable("data/localizacao.csv", "header");
		println("Loaded Column" + tabela.getColumnCount() + " data entries");
		println("Loaded Row" + tabela.getRowCount() + " data entries");
		
		//shadeArea();
	}
	
	public void draw() {
		map.draw();
		
		/*float longitude = 0;
		float latitude = 0;
		Location carregaCoordenada = null;
		
		//Percorrer o For e adicionar os marcadores 
		Location prefeitura = new Location(longitude, latitude);
		ScreenPosition pos = map.getScreenPosition(carregaCoordenada);
		ellipse(pos.x, pos.y, 15, 15);*/
	}
	
	/*public void shadeArea() {
		for (Marker marker : areaMarkers) {
			int i=0;
			// Find data for area of the current marker
			String placeId = marker.getId();
			System.out.println("Id do Json: "+placeId);
			DataEntry dataEntry = dataEntriesMap.get(placeId);
			System.out.println("Id do arquivo: "+dataEntry.place);
			
			if (dataEntry != null && dataEntry.value != null) {
				// Encode value as brightness (values range: 0-1000)
				float transparency = map(dataEntry.value, 0, 700, 10, 255);
				marker.setColor(color(style[i], transparency));
			} else {
				// No value available
				marker.setColor(color(100, 120));
			}
			i++;
		}
	}
	
	public HashMap<String, DataEntry> loadDatasFromCSV(String fileName) {
		HashMap<String, DataEntry> dataEntriesMap = new HashMap<String, DataEntry>();

		String[] rows = loadStrings(fileName);
		for (String row : rows) {
			// Reads datas value from CSV row
			
			String[] columns = row.split(";");
			System.out.println("Quantidade de Colunas: "+ columns.length);
			if (columns.length >= 3) {
				DataEntry dataEntry = new DataEntry();
				dataEntry.id = columns[0];	//first column
				System.out.println("Bairro do arquivo: "+ dataEntry.place);
				dataEntry.place = columns[1];	//Second column
				dataEntry.value = columns[2]; 	//third column
				dataEntriesMap.put(dataEntry.id, dataEntry);
			}
		}

		return dataEntriesMap;
	}

	class DataEntry {
		String id;
		String place;
		Location coordenadas;
		String value;
	}*/
	
}
