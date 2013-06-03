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
package com.agorex.parse.data;

import com.agorex.parse.search.ResultSetTokenRange;
import com.agorex.parse.search.annotation.ResultSetAnnotation;

public final class DataAllAnnotation {

   private transient int annotation;
   private final transient ResultSetAnnotation resultSetAnnotation = new ResultSetAnnotation(10);
   private final transient ResultSetTokenRange resultSetTokenRangeExclusive = new ResultSetTokenRange(10);
   private final transient ResultSetTokenRange resultSetTokenRangeInclusive = new ResultSetTokenRange(10);


   public int getAnnotation() { return annotation; }
   public void setAnnotation(final int annotation) { this.annotation = annotation; }


   public void addFirstAndLast(final int annotation, final int minToken, final int token, final int maxToken) {
      assert minToken <= token : "Minimum token " + minToken + " must be less than or equal to token " + token;
      assert token <= maxToken : "Token " + token + " must be less than or equal to maximum token " + maxToken;
      assert resultSetAnnotation.getSize() < 0 : "Must be first annotation added";

      //
      // Add the first annotation.
      //
      addFirst(annotation, minToken, token);

      //
      // Last annotation range being added.
      //
      resultSetTokenRangeExclusive.add(token + 1, maxToken);
      resultSetTokenRangeInclusive.add(token, maxToken);
   }


   public void addFirst(final int annotation, final int minToken, final int token) {

      assert minToken <= token : "Minimum token " + minToken + " must be less than or equal to token " + token;
      assert resultSetAnnotation.getSize() < 0 : "Must be first annotation added";

      resultSetAnnotation.add(annotation, token);

      //
      // First annotation being added.
      //
      resultSetTokenRangeExclusive.add(minToken, token - 1);
      resultSetTokenRangeInclusive.add(minToken, token);
   }


   public void add(final int annotation, final int token) {
      final int previousToken;

      assert resultSetAnnotation.getSize() >= 0 : "Must not be the first annotation added";

      //
      // Get the last token added.
      //
      previousToken = getToken(resultSetAnnotation.getSize());

      //
      // Add an annotation.
      //
      resultSetAnnotation.add(annotation, token);

      //
      // Add annotation range.
      //
      resultSetTokenRangeExclusive.add(previousToken + 1, token - 1);
      resultSetTokenRangeInclusive.add(previousToken, token);
   }


   public void addLast(final int annotation, final int token, final int maxToken) {

      assert token <= maxToken : "Token " + token + " must be less than or equal to maximum token " + maxToken;
      assert resultSetAnnotation.getSize() >= 0 : "Must not be the first annotation added";

      add(annotation, token);

      //
      // Add last range.
      //
      resultSetTokenRangeExclusive.add(token + 1, maxToken);
      resultSetTokenRangeInclusive.add(token, maxToken);
   }


   public void addRange(final int tokenStartExclusive, final int tokenEndExclusive, final int tokenStartInclusive, final int tokenEndInclusive) {
      resultSetTokenRangeExclusive.add(tokenStartExclusive, tokenEndExclusive);
      resultSetTokenRangeInclusive.add(tokenStartInclusive, tokenEndInclusive);
   }


   public int getSize() {
      return resultSetAnnotation.getSize();
   }


   public int getRangeSize() {
      return resultSetTokenRangeExclusive.getSize();
   }


   public int getAnnotation(final int index) {
      return resultSetAnnotation.getAnnotation(index);
   }


   public int getToken(final int index) {
      return resultSetAnnotation.getToken(index);
   }


   public ResultSetTokenRange getResultSetTokenRangeExclusive() {
      return resultSetTokenRangeExclusive;
   }


   public ResultSetTokenRange getResultSetTokenRangeInclusive() {
      return resultSetTokenRangeInclusive;
   }
}
