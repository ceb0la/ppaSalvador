package principal;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import processing.*;

public class OrcamentoBolhas extends PApplet {

	public void setup() {
		size(1800, 1000);
		stroke(50, 100, 150);
		strokeWeight(2);
	}
	
	public void draw() {
		background(255);
		line(0, (height / 2) + 200, width, (height / 2) + 200);
		
		//Map Title
		String title ="Recurso Orçamentário e Extraorçamentário por Eixo";
		textSize(32);
		fill(0, 0, 0, 500);
		text(title, (width/2)-400, 100);
		
		int[] style = {	color(1,22,39),
						color(119,63,76),
						color(46,196,182),
						color(231,29,54),
						color(255,159,28),
						color(166,204,146),
						color(154,86,255),
						color(75,196,45) 
				};

		// Loading the file into a table. “header” means that the first line of the file
		// should be understood as a header.
		Table tabela = loadTable("data/custos.tsv", "header");
		textSize(15);
		float d = 0;
		// Creates an action that will be repeated several times …
		for (int i = 0; i < tabela.getRowCount(); i = i + 1) {
			TableRow linha = tabela.getRow(i);
			println(i);
			println(tabela.getRowCount());
			println("ID: " + linha.getInt("id") + " Orçamento: " + linha.getLong("orcamento"));

			float perimeter = 0;
			perimeter = (linha.getLong("orcamento")) / 50000000;
			// float posX = 100+120*i;

			d = d + perimeter;
			float posX = d;
			float posY = (height / 2) + 200;

			fill(style[i]);
			ellipse(posX + (perimeter * 2), posY, perimeter, perimeter);
			
			fill(style[i]);
			pushMatrix();
			translate(posX + (perimeter * 2), posY - (perimeter / 2));
			rotate(radians(-45));
			text(linha.getString("tipo"), 0, 0);
			text("R$"+ linha.getLong("orcamento"), 14,14);
			// text(linha.getString("tipo"), posX+(perimeter*2), posY-(perimeter/2));
			popMatrix();
			
			// ellipse(mouseX, mouseY, raio, raio);
			// ellipse(posicaoX, posicaoY,largura,altura);
		}
	}
}