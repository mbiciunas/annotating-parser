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
package com.agorex.parse.search.landmark;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.agorex.parse.AbstractTestResultSetLandmark;
import com.agorex.parse.data.Data;

public final class FindAllLandmarkTest extends AbstractTestResultSetLandmark {

   @Test
   public void testFind() {
      for (int index = 0; index < super.getDataArraySize(); ++index) {
         assertTrue(super.getDataArrayData(index).getClassName() + " - Run failed", run(super.getDataArrayData(index)));
      }
   }


   private boolean run(final Data data) {
      final ResultSetLandmark resultSetLandmark;

      initialize(data.getStatement());

      resultSetLandmark = FindAllLandmark.find(getParseData(), getResultSingleTokenRange(), data.getAllLandmarkRange().getLandmarkData());

      validate(data.getClassName(), data.getAllLandmark().getResultSetLandmark(), resultSetLandmark);

      return true;
   }

}
