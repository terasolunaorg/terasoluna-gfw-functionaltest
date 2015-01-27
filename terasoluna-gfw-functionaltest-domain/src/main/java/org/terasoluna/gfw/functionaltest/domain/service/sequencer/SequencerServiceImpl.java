/*
 * Copyright (C) 2013-2015 terasoluna.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.terasoluna.gfw.functionaltest.domain.service.sequencer;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.sequencer.Sequencer;

@Service
public class SequencerServiceImpl implements SequencerService {

	@Resource
    protected Sequencer<Integer> integerSeq;

	@Resource
    protected Sequencer<Long> longSeq;

	@Resource
    protected Sequencer<BigInteger> bigIntegerSeq;
	
	@Resource
    protected Sequencer<String> stringSeq;
	
	@Resource
    protected Sequencer<Integer> notFoundSeq;

	@Override
	public Integer getNextValueByInteger() {
		Integer integerSequence = integerSeq.getNext();
		return integerSequence;
	}

	@Override
	public Integer getCurrentValueByInteger() {
		Integer integerSequence = integerSeq.getCurrent();
		return integerSequence;
	}

	@Override
	public Long getNextValueByLong() {
		Long longSequence = longSeq.getNext();
		return longSequence;
	}

	@Override
	public Long getCurrentValueByLong() {
		Long longSequence = longSeq.getCurrent();
		return longSequence;
	}

	@Override
	public BigInteger getNextValueByBigInteger() {
		BigInteger bigIntegerSequence = bigIntegerSeq.getNext();
		return bigIntegerSequence;
	}

	@Override
	public BigInteger getCurrentValueByBigIneter() {
		BigInteger bigIntegerSequence = bigIntegerSeq.getCurrent();
		return bigIntegerSequence;
	}

	@Override
	public String getNextValueByString() {
		String stringSequence = stringSeq.getNext();
		return stringSequence;
	}

	@Override
	public String getCurrentValueByString() {
		String stringSequence = stringSeq.getCurrent();
		return stringSequence;
	}

	@Override
	public Integer getNotFoundSequenceNext() {
		Integer integerSequence = notFoundSeq.getNext();
		return integerSequence;
	}
	
	@Override
	public Integer getNotFoundSequenceCurrent() {
		Integer integerSequence = notFoundSeq.getCurrent();
		return integerSequence;
	}

}
