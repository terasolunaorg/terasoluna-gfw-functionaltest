/*
 * Copyright (C) 2013-2018 NTT DATA Corporation
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
import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.sequencer.Sequencer;
import org.terasoluna.gfw.functionaltest.domain.TransactionManagers;

@Service
@Transactional(value = TransactionManagers.DATASOURCE)
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
    public Integer getNotFoundSequenceNext() {
        Integer integerSequence = notFoundSeq.getNext();
        return integerSequence;
    }

    @Override
    public Integer getNotFoundSequenceCurrent() {
        Integer integerSequence = notFoundSeq.getCurrent();
        return integerSequence;
    }

    @Override
    public LinkedHashMap<String, BigInteger> getSequencerBigIntegers() {
        LinkedHashMap<String, BigInteger> output = new LinkedHashMap<String, BigInteger>();
        setSequencerValuesOutput(bigIntegerSeq, output);
        return output;
    }

    @Override
    public LinkedHashMap<String, Integer> getSequencerIntegers() {
        LinkedHashMap<String, Integer> output = new LinkedHashMap<String, Integer>();
        setSequencerValuesOutput(integerSeq, output);
        return output;
    }

    @Override
    public LinkedHashMap<String, Long> getSequencerLongs() {
        LinkedHashMap<String, Long> output = new LinkedHashMap<String, Long>();
        setSequencerValuesOutput(longSeq, output);
        return output;
    }

    @Override
    public LinkedHashMap<String, String> getSequencerStrings() {
        LinkedHashMap<String, String> output = new LinkedHashMap<String, String>();
        setSequencerValuesOutput(stringSeq, output);
        return output;
    }

    @SuppressWarnings("unchecked")
    private <T, E> void setSequencerValuesOutput(Sequencer<T> sequencer,
            LinkedHashMap<String, E> output) {
        output.put("next_value1", (E) sequencer.getNext());
        output.put("current_value1", (E) sequencer.getCurrent());
        output.put("current_value2", (E) sequencer.getCurrent());
        output.put("next_value2", (E) sequencer.getNext());
        output.put("next_value3", (E) sequencer.getNext());
        output.put("current_value3", (E) sequencer.getCurrent());
        output.put("next_value4", (E) sequencer.getNext());
        output.put("current_value4", (E) sequencer.getCurrent());
    }
}
