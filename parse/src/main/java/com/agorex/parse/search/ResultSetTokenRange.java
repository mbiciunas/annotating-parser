/*
 * Copyright 2013 Mark Biciunas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorex.parse.search;

import java.util.Arrays;

import com.agorex.parse.utility.AbstractResizable;



/**
 * @author mbiciunas
 *
 */
/**
 * @author mbiciunas
 *
 */
public final class ResultSetTokenRange extends AbstractResizable {

   private transient TokenRange[] resultSingleTokenRange;


   /**
    * @param capacity initial number of elements in result set.
    */
   public ResultSetTokenRange(final int capacity) {
      super(capacity);
      resultSingleTokenRange = new TokenRange[capacity];
   }


   /**
    * @param tokenStart token at start of range.
    * @param tokenEnd token at end of range.
    */
   public void add(final int tokenStart, final int tokenEnd) {
      increment();

      resultSingleTokenRange[getSize()] = new TokenRange(tokenStart, tokenEnd);
   }


   /**
    * @param landmark landmark associated with the range.
    * @param tokenStart token at start of range.
    * @param tokenEnd token at end of range.
    */
   public void add(final String landmark, final int tokenStart, final int tokenEnd) {
      increment();

      resultSingleTokenRange[getSize()] = new TokenRange(landmark, tokenStart, tokenEnd);
   }


   /**
    * @param annotation value of annotation.
    * @param tokenStart token at start of range.
    * @param tokenEnd token at end of range.
    */
   public void add(final int annotation, final int tokenStart, final int tokenEnd) {
      increment();

      resultSingleTokenRange[getSize()] = new TokenRange(String.valueOf(annotation), tokenStart, tokenEnd);
   }


   /**
    * @param index position of token range to return.
    * @return token range identified by the index.
    */
   public TokenRange getTokenRange(final int index) {
      return resultSingleTokenRange[index];
   }


   /**
    * @param landmark identifier for the token range to find.
    * @return token range found.
    */
   public TokenRange find(final String landmark) {
      TokenRange tokenRangeFound = null;

      for (int index = 0; index <= getSize(); ++index) {
         if (resultSingleTokenRange[index].getName().equals(landmark)) {
            tokenRangeFound = resultSingleTokenRange[index];
            break;
         }
      }

      return tokenRangeFound;
   }


   @Override
   protected void addCapacity(final int newCapacity) {
      resultSingleTokenRange = Arrays.copyOf(resultSingleTokenRange, newCapacity);
   }
}
