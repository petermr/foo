package org.xmlcml.ami2.plugins.search;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.xmlcml.ami2.plugins.AMIArgProcessor;
import org.xmlcml.ami2.plugins.AMISearcher;
import org.xmlcml.ami2.plugins.regex.CompoundRegex;
import org.xmlcml.ami2.plugins.regex.RegexComponent;
import org.xmlcml.ami2.plugins.word.WordArgProcessor;
import org.xmlcml.ami2.plugins.word.WordCollectionFactory;
import org.xmlcml.cmine.files.ResultContainerElement;
import org.xmlcml.cmine.lookup.DefaultStringDictionary;

import nu.xom.Element;

public class SearchSearcher extends AMISearcher {

	
	public static final Logger LOG = Logger.getLogger(SearchSearcher.class);
	static {
		LOG.setLevel(Level.DEBUG);
	}
	
	List<RegexComponent> componentList;
	private CompoundRegex compoundRegex;
	Element resultElement;
	private List<String> searchWords;
	private ResultContainerElement resultsElement;
	
	public SearchSearcher(AMIArgProcessor argProcessor, DefaultStringDictionary dictionary) {
		super(argProcessor, dictionary);
	}

	public static AMISearcher createSearcher(AMIArgProcessor argProcessor, DefaultStringDictionary dictionary) {
		return new SearchSearcher(argProcessor, dictionary);
	}

	void setSearchWords(List<String> searchWords) {
		this.searchWords = searchWords;
	}

	// ====== args ========

	/**
	 * 
	 * @return resultsElements 
	 */
	public ResultContainerElement searchWordList() {
		List<String> strings = new WordCollectionFactory((SearchArgProcessor)this.getArgProcessor()).createWordList();
		ResultContainerElement resultsElement = searchWithDictionary(strings);
		return resultsElement;
	}

	public ResultContainerElement getResultsElement() {
		return resultsElement;
	}

	

	// ===============
	
	public void debug() {
		LOG.debug(compoundRegex.getTitle()+"/"+compoundRegex.getRegexValues().size());
	}


}
