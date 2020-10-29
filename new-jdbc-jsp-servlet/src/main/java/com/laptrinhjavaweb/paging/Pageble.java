package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public interface Pageble {
	public Integer getPage();
	public Integer getOffset();
	public Integer getLimit();
	public Sorter getSorter();
}
