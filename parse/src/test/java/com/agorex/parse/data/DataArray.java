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

import java.util.ArrayList;
import java.util.List;


/**
 * @author mbiciunas
 *
 */
public final class DataArray {

   private final transient List<Data> arrayData = new ArrayList<>();


   /**
    * @param data object containing the statement and correct parsing data
    */
   public void addData(final Data data) { arrayData.add(data); }


   /**
    * @param index position in the data set
    * @return object containing a statement and correct parsing data for that statement
    */
   public Data getData(final int index) { return arrayData.get(index); }


   /**
    * @return number of data objects
    */
   public int size() { return arrayData.size(); }
}
