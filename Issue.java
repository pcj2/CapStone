/*  Created by Perry Journey
*     9/10/2016
*
*   Class Issue contains all relevant information pertaining to an issue that
    will be displayed in the GUI.
*
*   Issue Colors:
*             Red     ->    #F44336
*             Yellow  ->    #FFC107
*             Green   ->    #4CAF50
*             Blue    ->    #03A9F4
*             Purple  ->    #673AB7
*             Brown   ->    #795548
*             Grey    ->    #9E9E9E
*
*/

import java.swing.*;

public class Issue(){
  private String title = null;
  private String info = null;
  private String color = null;
  private String version = null;
  private String[] categories = new String[99];

  public Issue(){}
  public Issue(String title, String info, String categories){
    this.title = title;
    this.info = info;
    this.categories = categories;
  }

  //Set Methods
  public void setTitle(String title){this.title = title;}
  public void setInfo(String info){this.info = info;}
  public void setCategories(String[] categories){this.categories = categories;}
  public void setVersion(String version){this.version = version;}
  //Get Methods
  public String getTitle(){return title;}
  public String getInfo(){return info;}
  public String[] getCategories(){return categories;}
  public Issue getIssue(){return this;}
  public String getVersion(){return version;}
  //TODO create get methdo to return JavaFX element displaying this class's information
}
