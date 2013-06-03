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


public final class Data {

   private transient String statement;
   private transient String description;
   private transient String className;

   private transient DataToken dataToken = new DataToken();
   private transient DataAnnotationState dataAnnotationState = new DataAnnotationState();
   private transient DataAllBracket dataAllBracket = new DataAllBracket();
   private transient DataAllAnnotation dataAllAnnotation = new DataAllAnnotation();
   private transient DataAllLandmark dataAllLandmark = new DataAllLandmark();
   private transient DataAllLandmarkForward dataAllLandmarkForward = new DataAllLandmarkForward();
   private transient DataAllLandmarkRange dataAllLandmarkRange = new DataAllLandmarkRange();


   public String getStatement() { return statement; }
   public void setStatement(final String statement) { this.statement = statement; };

   public String getDescription() { return description; }
   public void setDescription(final String description) { this.description = description; };

   public String getClassName() { return className; }
   public void setClassName(final String className) { this.className = className; };

   public DataToken getToken() { return dataToken; }
   public void setToken(final DataToken dataToken) { this.dataToken = dataToken; };

   public DataAnnotationState getAnnotation() { return dataAnnotationState; }
   public void setAnnotation(final DataAnnotationState dataAnnotation) { dataAnnotationState = dataAnnotation; };

   public DataAllBracket getAllBracket() { return dataAllBracket; }
   public void setAllBracket(final DataAllBracket dataAllBracket) { this.dataAllBracket = dataAllBracket; };

   public DataAllAnnotation getAllAnnotation() { return dataAllAnnotation; }
   public void setAllAnnotation(final DataAllAnnotation dataAllAnnotation) { this.dataAllAnnotation = dataAllAnnotation; };

   public DataAllLandmark getAllLandmark() { return dataAllLandmark; }
   public void setAllLandmark(final DataAllLandmark dataAllLandmark) { this.dataAllLandmark = dataAllLandmark; };

   public DataAllLandmarkForward getAllLandmarkForward() { return dataAllLandmarkForward; }
   public void setAllLandmarkForward(final DataAllLandmarkForward dataAllLandmarkForward) { this.dataAllLandmarkForward = dataAllLandmarkForward; };

   public DataAllLandmarkRange getAllLandmarkRange() { return dataAllLandmarkRange; }
   public void setAllLandmarkRange(final DataAllLandmarkRange dataAllLandmarkRange) { this.dataAllLandmarkRange = dataAllLandmarkRange; };
}
