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
package com.agorex.parse.data.sql;

import com.agorex.parse.annotation.AnnotationState.BracketState;
import com.agorex.parse.annotation.AnnotationState.QuoteState;
import com.agorex.parse.data.AbstractData;
import com.agorex.parse.data.Data;
import com.agorex.parse.data.DataAllAnnotation;
import com.agorex.parse.data.DataAllBracket;
import com.agorex.parse.data.DataAllLandmark;
import com.agorex.parse.data.DataAllLandmarkForward;
import com.agorex.parse.data.DataAllLandmarkRange;
import com.agorex.parse.data.DataAnnotationState;
import com.agorex.parse.data.DataToken;

/**
 * @author mbiciunas
 *
 */
final class DataSqlBracket03 extends AbstractData {

   /**
    *
    */
   DataSqlBracket03() {
      super();
   }


   @Override
   public Data makeData() {
      final Data data = new Data();

      data.setClassName(this.getClass().getSimpleName());
      data.setStatement("SELECT (first_name) FROM (employee");
      data.setDescription("Open a second bracket");

      return data;
   }


   @Override
   protected void loadToken(final DataToken dataToken) {
      dataToken.add(0, 6, ConfigurationSql.ANNOTATION_NONE);
      dataToken.add(7, 8, ConfigurationSql.ANNOTATION_BRACKET_OPEN);
      dataToken.add(8, 18, ConfigurationSql.ANNOTATION_NONE);
      dataToken.add(18, 19, ConfigurationSql.ANNOTATION_BRACKET_CLOSE);
      dataToken.add(20, 24, ConfigurationSql.ANNOTATION_NONE);
      dataToken.add(25, 26, ConfigurationSql.ANNOTATION_BRACKET_OPEN);
      dataToken.add(26, 34, ConfigurationSql.ANNOTATION_NONE);
   }


   @Override
   protected void loadAnnotationState(final DataAnnotationState dataAnnotationState) {
      dataAnnotationState.setQuoteState(QuoteState.NONE);
      dataAnnotationState.setBracketState(BracketState.OPEN);
      dataAnnotationState.setBracketDepth(1);
      dataAnnotationState.setBracketStart(6);
      dataAnnotationState.setBracketEnd(-1);
   }


   @Override
   protected void loadAllBracket(final DataAllBracket dataAllBracket) {
      dataAllBracket.add(2, 2);
   }


   @Override
   protected void loadAllAnnotation(final DataAllAnnotation dataAllAnnotation) {
      dataAllAnnotation.setAnnotation(ConfigurationSql.ANNOTATION_BRACKET_OPEN);

      dataAllAnnotation.addFirst(ConfigurationSql.ANNOTATION_BRACKET_OPEN, 0, 1);
      dataAllAnnotation.addLast(ConfigurationSql.ANNOTATION_BRACKET_OPEN, 5, 6);
   }


   @Override
   protected void loadAllLandmark(final DataAllLandmark dataAllLandmark) {
      dataAllLandmark.getLandmarkData().add("select");
      dataAllLandmark.getLandmarkData().add("from");

      dataAllLandmark.add("select".toCharArray(), 0);
      dataAllLandmark.add("from".toCharArray(), 4);
   }


   @Override
   protected void loadAllLandmarkForward(final DataAllLandmarkForward dataAllLandmark) {
      dataAllLandmark.getLandmarkData().add("select");
      dataAllLandmark.getLandmarkData().add("FROM");

      dataAllLandmark.addFirst("select".toCharArray(), 0);
      dataAllLandmark.addLast("from".toCharArray(), 4, 6);
   }


   @Override
   protected void loadAllLandmarkRange(final DataAllLandmarkRange dataAllLandmarkRange) {
      dataAllLandmarkRange.getLandmarkData().add("select");
      dataAllLandmarkRange.getLandmarkData().add("from");

      dataAllLandmarkRange.addFirst("select".toCharArray(), 0, 0);
      dataAllLandmarkRange.addLast("from".toCharArray(), 4, 6);
   }
}
