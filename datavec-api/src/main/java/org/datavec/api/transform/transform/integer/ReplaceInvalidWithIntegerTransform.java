/*
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package org.datavec.api.transform.transform.integer;

import org.datavec.api.io.data.IntWritable;
import org.datavec.api.writable.Writable;

/**
 * Replace an invalid (non-integer) value in a column with a specified integer
 */
public class ReplaceInvalidWithIntegerTransform extends BaseIntegerTransform {

    private final int intValue;

    public ReplaceInvalidWithIntegerTransform(String column, int intValue) {
        super(column);
        this.intValue = intValue;
    }

    @Override
    public Writable map(Writable writable) {
        if(inputSchema.getMetaData(columnNumber).isValid(writable)){
            return writable;
        } else {
            return new IntWritable(intValue);
        }
    }
}