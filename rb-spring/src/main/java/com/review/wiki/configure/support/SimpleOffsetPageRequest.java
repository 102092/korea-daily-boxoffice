package com.review.wiki.configure.support;

public class SimpleOffsetPageRequest implements Pageable {

	private final long offset;

	private final int limit;

	public SimpleOffsetPageRequest() {
		this(0, 5);
	}

	public SimpleOffsetPageRequest(long offset, int limit) {
		if (offset < 0)
			throw new IllegalArgumentException("Offset must be greater or equals zero.");
		
        if (limit < 1)
            throw new IllegalArgumentException("Limit must be greater than zero.");


		this.offset = offset;
		this.limit = limit;
	}

	@Override
	public long offset() {
		return offset;
		
	}

	@Override
	public int limit() {
		return limit;
	}
}
