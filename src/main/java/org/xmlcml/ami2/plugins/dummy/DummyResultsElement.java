package org.xmlcml.ami2.plugins.dummy;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xmlcml.cmine.files.ResultContainerElement;

public class DummyResultsElement extends ResultContainerElement {

	private static final Logger LOG = Logger.getLogger(DummyResultsElement.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	private static final String PHYLO = "phylo";
	private DummyResultsElement(String title) {
		super(title);
	}

	public DummyResultsElement() {
		this(PHYLO);
	}
	
}
