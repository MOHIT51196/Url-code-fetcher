import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class UrlCodeFetcher {
	public static void main(String [] args) {
	      try {
	    	  System.out.println(" keeping the console active.......... ");
	    	 String webUrl =  JOptionPane.showInputDialog("Enter the url");
	         URL url = new URL(webUrl);
	         URLConnection urlConnection = url.openConnection();
	         HttpURLConnection connection = null;
	         if(urlConnection instanceof HttpURLConnection) {
	            connection = (HttpURLConnection) urlConnection;
	         }
	         
	         else {
	            System.out.println("Please enter an HTTP URL.");
	            return;
	         }
	         
	         BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));
	         String urlString = "";
	         String current;
	         
	         while((current = in.readLine()) != null) {
	            urlString += current+"\n";
	         }
	         System.out.println(urlString);
	         
	        try {
				Desktop.getDesktop().browse(url.toURI());
			} 
	        catch (URISyntaxException e) {
				System.out.println("URI ERROR: "+e.getMessage());
				e.printStackTrace();
			}
	        
	      }
	      
	      catch(IOException e) {
	    	  System.out.println("CONNECTION INPUT ERROR : " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
}
