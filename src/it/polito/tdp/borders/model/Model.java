package it.polito.tdp.borders.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private List<Country> countries;
	private List<Contiguity> confinanti;
	
	private BordersDAO dao;
	private SimpleGraph<Country, DefaultEdge> grafo = null;
	
	
	public Model(){
		
		this.dao = new BordersDAO();
	}
	
	
	

	public void creaGrafo(int anno) {
		
		// Collect info
		
		confinanti = dao.loadAllContiguity(anno);
		
		
		// Inizializzazione
		grafo = new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
		
		
		
		// Aggiungo i vertici al grafo
		for(Contiguity c: confinanti){
			
			Country c1 = c.getStateUno();
			Country c2 = c.getStateDue();
			
			
				grafo.addVertex(c1);
				grafo.addVertex(c2);
			
			
		}
		
		
		
		// Aggiungo gli archi al grafo
		for(Contiguity c: confinanti){
			
			Country c1 = c.getStateUno();
			Country c2 = c.getStateDue();
			
			if(!c1.equals(c2))
				grafo.addEdge(c1, c2);
			
		}
		
		countries = new ArrayList<>(grafo.vertexSet());
		
		
	}




	/**
	 * @return the grafo
	 */
	public SimpleGraph<Country, DefaultEdge> getGrafo(int anno) {
		
		if(grafo == null)
			this.creaGrafo(anno);
		
		return grafo;
	}



	public List<CountryCount> getConfinanti() {
	
		
		List<CountryCount> confinanti = new ArrayList<>() ;
		
		for(Country c: grafo.vertexSet())
			confinanti.add( new CountryCount(c, grafo.degreeOf(c))) ;
		
		
		Collections.sort(confinanti);
		
		return confinanti;
			
}
	




}
