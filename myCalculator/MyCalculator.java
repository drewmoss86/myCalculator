/**************************************
 * Name: Andrew Moss
 * 
 * Class: CIS 016 - Java
 * 
 * Assignment: 11_GUI_Elements_Calculator Part2
 * 
 * Date: 11/29/2018
 * 
 **************************************/

package myCalculator;

import java.nio.file.attribute.PosixFilePermission;

import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;  //entire window

import java.lang.Math;
public class MyCalculator extends Application
{
	Stage window;
	private String strVar1 = "";
	private String strVar2 = "";
	private String strTotal = "";
	private String operator = "";
	private int total = 0;
	private double d_var1 = 0;
	private double d_var2 = 0;
	private double d_total = 0;
	private boolean op_selected = false;
//	private boolean dec_selected = false;
	private int buttonWidth = 60;
	private int buttonHeight = 60;

	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		launch(args);  //launches javaFX
	}
	
	public void set_display_button(String button, TextField tf) {
		if(!op_selected) { 
			strVar1 += button;
			System.out.println("strVar1: " + strVar1);
			System.out.println("strVar2: " + strVar2);

			d_var1 = Double.parseDouble(strVar1); 
			System.out.println("d_var1: " + d_var1);
			System.out.println("d_var2: " + d_var2);
			tf.setText(strVar1); 
			
//			if(dec_selected) { 
//				d_var1 = Double.parseDouble(strVar1); 
//				tf.setText(strVar1); 
//				dec_selected = false;
//			} else { 
//				var1 = Integer.parseInt(strVar1); 
//				tf.setText(strVar1); 
//				dec_selected = false;
//			} 
		} else { 
			strVar2 += button;
			System.out.println("strVar2: " + strVar2);
			
			d_var2 = Double.parseDouble(strVar2); 
			System.out.println("d_var2: " + d_var2);
			tf.setText(strVar2); 
			
//			if(dec_selected) { 
//				d_var2 = Double.parseDouble(strVar2); 
//				tf.setText(strVar2); 
//				dec_selected = false;
//			} else { 
//				var2 = Integer.parseInt(strVar2); 
//				tf.setText(strVar2); 
//				dec_selected = false;
//			} 
		}
	}
	
	public int calculate(int x, int y, String operator) {
		System.out.println("x: " + x + " " + "y: " + y);
		switch(operator) {
		case "+" : 
			return x += y;
		case "-" : 
			return x -= y;
		case "*" : 
			return x *= y;
		case "/" :
			if(y == 0) { return 0; }	
			return x /= y;
		default : 
			return 0;
		}
	}
	//overload calc function for decimal
	public double d_calculate(double x, double y, String operator) {
//		System.out.println("x: " + x + " y: " + y);  //print in console for testing
		switch(operator) {
		case "+" : 
			return x += y;
		case "-" : 
			return x -= y;
		case "*" : 
			return x *= y;
		case "/" :
			if(y == 0) { return 0; }	
			return x /= y;
		default : 
			return 0;
		}
	}
	
	public void memberVarReset() {
		operator = ""; //reset operator
		strVar1 = ""; //reset strVar1
		strVar2 = ""; //reset strVar2
		d_var1 = 0; //reset d_var1
		d_var2 = 0; //reset d_var2
		op_selected = false;
	}
	
	public void setOperator(String op, boolean op_sel) {
		operator = op;
		op_selected = op_sel;
		if(strVar1.isEmpty()) { strVar1 = "0"; }
	}

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws Exception
	{
		//stage --> scene --> container --> node

		window = primaryStage;  //assign primaryStage to window
		primaryStage.setTitle("My Calculator"); // Set the stage title
		
		GridPane grid = new GridPane();  //create grid object
		
		grid.setPadding(new Insets(20, 15, 15, 15));  //sets padding between edge of window and grid on all four sides
		grid.setVgap(15);
		grid.setHgap(15);
		
		//Number input
		TextField numInput = new TextField();  //create input field for calculator		
		numInput.prefWidthProperty().bind(grid.widthProperty()); //auto resizing
		GridPane.setColumnSpan(numInput, 4);;  //place numinput onto grid
		HBox container = new HBox(numInput);
		container.setAlignment(Pos.CENTER);
		container.setPadding(new Insets(10));
		
		//Num1 Button
		Button num1 = new Button("1");  //create number 1 button
		GridPane.setConstraints(num1, 0, 5);  //set number 1 button on grid
		num1.setOnAction(e -> { set_display_button("1", numInput); } );
		num1.setPrefSize(buttonWidth, buttonHeight);
		
		//Num2 Button
		Button num2 = new Button("2");  //create number 2 button
		GridPane.setConstraints(num2, 1, 5);  //set number 2 button on grid
		num2.setOnAction(e -> { set_display_button("2", numInput); } );
		num2.setPrefSize(buttonWidth, buttonHeight);

		//Num3 Button
		Button num3 = new Button("3");  //create number 3 button
		GridPane.setConstraints(num3, 2, 5);  //set number 3 button on grid
		num3.setOnAction(e -> { set_display_button("3", numInput); } );
		num3.setPrefSize(buttonWidth, buttonHeight);

		//Num4 Button
		Button num4 = new Button("4");  //create number 4 button
		GridPane.setConstraints(num4, 0, 4);  //set number 1 button on grid
		num4.setOnAction(e -> { set_display_button("4", numInput); } );
		num4.setPrefSize(buttonWidth, buttonHeight);

		//Num5 Button
		Button num5 = new Button("5");  //create number 5 button
		GridPane.setConstraints(num5, 1, 4);  //set number 2 button on grid
		num5.setOnAction(e -> { set_display_button("5", numInput); } );
		num5.setPrefSize(buttonWidth, buttonHeight);

		//Num6 Button
		Button num6 = new Button("6");  //create number 6 button
		GridPane.setConstraints(num6, 2, 4);  //set number 3 button on grid
		num6.setOnAction(e -> { set_display_button("6", numInput); } );
		num6.setPrefSize(buttonWidth, buttonHeight);

		//Num7 Button
		Button num7 = new Button("7");  //create number 7 button
		GridPane.setConstraints(num7, 0, 3);  //set number 1 button on grid
		num7.setOnAction(e -> { set_display_button("7", numInput); } );
		num7.setPrefSize(buttonWidth, buttonHeight);

		//Num8 Button
		Button num8 = new Button("8");  //create number 8 button
		GridPane.setConstraints(num8, 1, 3);  //set number 2 button on grid
		num8.setOnAction(e -> { set_display_button("8", numInput); } );
		num8.setPrefSize(buttonWidth, buttonHeight);

		//Num9 Button
		Button num9 = new Button("9");  //create number 9 button
		GridPane.setConstraints(num9, 2, 3);  //set number 3 button on grid
		num9.setOnAction(e -> { set_display_button("9", numInput); } );
		num9.setPrefSize(buttonWidth, buttonHeight);
		
		//Num0 Button
		Button num0 = new Button("0");  //create number 0 button
		GridPane.setConstraints(num0, 0, 6);  //set number 3 button on grid
		GridPane.setColumnSpan(num0, 2);
		num0.setOnAction(e -> { 
			if(!op_selected) {
				if(strVar1.isEmpty()) {
//					strVar1 = " ";  //set strVar1 to empty
					numInput.setText("0");
				} else if(!strVar1.isEmpty() && Double.parseDouble(strVar1) > 0) { 
					strVar1 += "0"; 
					System.out.println("strVar1in0+= : " + strVar1);
					d_var1 = Double.parseDouble(strVar1);
					System.out.println("strVar1in0+= : " + strVar1);
					numInput.setText(Integer.toString((int)d_var1));
				}
			} else {
				if(strVar2.isEmpty()) {
					numInput.setText("0");
				} else if(!strVar2.isEmpty() && Integer.parseInt(strVar2) > 0) { 
					strVar2 += "0"; 
					System.out.println("strVar2in0+= : " + strVar2);
					d_var2 = Double.parseDouble(strVar2);
					System.out.println("strVar2in0+= : " + strVar2);
					numInput.setText(Integer.toString((int)d_var2));
				}
			} 
			
		} );
		num0.setPrefSize(115, buttonHeight);
		
		//Decimal Button
//		Button dec = new Button(".");  //create decimal button
//		GridPane.setConstraints(dec, 2, 6);  //set number 3 button on grid
//		dec.setOnAction(e -> { 
//			if(!op_selected) { 
//				strVar1 += ".";
//				System.out.println(strVar1);
//				numInput.setText(strVar1);
//				dec_selected = true;
//			} else { 
//				strVar2 += "."; 
//				System.out.println(strVar2);
//				numInput.setText(strVar2);
//				dec_selected = true;
//			}
//		});
//		dec.setPrefSize(buttonWidth, buttonHeight);

		//Add Button
		Button add = new Button("+");  //create plus button
		GridPane.setConstraints(add, 3, 3);  //set number 1 button on grid
		add.setOnAction(e -> { setOperator("+", true); });	
		add.setPrefSize(buttonWidth, buttonHeight);

		//Square Root Button
		Button sq_rt = new Button("√");  //create sq_rt button
		GridPane.setConstraints(sq_rt, 3, 2);  //set number 1 button on grid
		sq_rt.setOnAction(e -> { 
			d_var1 = Math.sqrt(Double.parseDouble(strVar1));
			if(d_var1 == Math.floor(d_var1) && !Double.isInfinite(d_var1)) {
				strVar1 = Integer.toString((int)d_var1);
			} else { strVar1 = Double.toString(d_var1); }
			numInput.setText(strVar1);
		});
		sq_rt.setPrefSize(buttonWidth, buttonHeight);
		
		//Square Button
		Button sq = new Button("n²");  //create sq_rt button
		GridPane.setConstraints(sq, 3, 1);  //set number 1 button on grid
		sq.setOnAction(e -> { 
			System.out.println("strVar1: " + strVar1);  //for debugging
			d_var1 = Math.pow(Double.parseDouble(strVar1), 2);
			System.out.println("d_var1: " + d_var1);  //for debugging
			System.out.println("flr: " + Math.floor(d_var1)); //for debugging
			if(d_var1 == Math.floor(d_var1) && !Double.isInfinite(d_var1)) { 
				strVar1 = Integer.toString((int)d_var1); 
			} else { strVar1 = Double.toString(d_var1); }
			
			numInput.setText(strVar1);
		});
		sq.setPrefSize(buttonWidth, buttonHeight);
		
		//Sin Button
		Button sin = new Button("sin");  //create sq_rt button
		GridPane.setConstraints(sin, 0, 1);  //set number 1 button on grid
		sin.setOnAction(e -> { 
			System.out.println("strVar1: " + strVar1);
			d_var1 = Math.sin(Double.parseDouble(strVar1));
			System.out.println("d_var1: " + d_var1);
			numInput.setText(Double.toString(d_var1));
			strVar1 = Double.toString(d_var1);
		});
		sin.setPrefSize(buttonWidth, buttonHeight);
		
		//Cos Button
		Button cos = new Button("cos");  //create sq_rt button
		GridPane.setConstraints(cos, 1, 1);  //set number 1 button on grid
		cos.setOnAction(e -> { 
			System.out.println("strVar1: " + strVar1);
			d_var1 = Math.cos(Double.parseDouble(strVar1));
			System.out.println("d_var1: " + d_var1);
			numInput.setText(Double.toString(d_var1));
			strVar1 = Double.toString(d_var1);
		});
		cos.setPrefSize(buttonWidth, buttonHeight);
		
		//Tan Button
		Button tan = new Button("tan");  //create sq_rt button
		GridPane.setConstraints(tan, 2, 1);  //set number 1 button on grid
		tan.setOnAction(e -> { 
			System.out.println("strVar1: " + strVar1);
			d_var1 = Math.cos(Double.parseDouble(strVar1));
			System.out.println("d_var1: " + d_var1);
			numInput.setText(Double.toString(d_var1));
			strVar1 = Double.toString(d_var1);
		});
		tan.setPrefSize(buttonWidth, buttonHeight);
		
		//Sub Button
		Button sub = new Button("-");  //create number 1 button
		GridPane.setConstraints(sub, 3, 4);  //set number 1 button on grid
		sub.setOnAction(e -> { 
			if(!op_selected && strVar1.isEmpty()) { strVar1 = "0"; numInput.setText(strVar1);}
			 { setOperator("-", true); }
						
		});	
		sub.setPrefSize(buttonWidth, buttonHeight);

		//Mult Button
		Button mult = new Button("x");  //create number 1 button
		GridPane.setConstraints(mult, 1, 2);  //set number 1 button on grid
		mult.setOnAction(e -> { setOperator("*", true); });	
		mult.setPrefSize(buttonWidth, buttonHeight);

		//Div Button
		Button div = new Button("÷");  //create number 1 button
		GridPane.setConstraints(div, 2, 2);  //set number 1 button on grid
		div.setOnAction(e -> { System.out.println("strVar2: " + strVar2); setOperator("/", true); });	
		div.setPrefSize(buttonWidth, buttonHeight);
		
		//Equal Button
		Button equal = new Button("=");  //create number 1 button
		GridPane.setConstraints(equal, 3, 5);  //set number 1 button on grid
		GridPane.setRowSpan(equal, 2);
		equal.setPrefSize(50, 100);
		equal.setOnAction(e -> {
			if(operator == "/" && (d_var2 == 0 /*|| var2 == 0*/)) {
				numInput.setText("Cannot divide by zero"); 
				memberVarReset();
			
			} else if(op_selected && strVar1.isEmpty()) {
				d_var1 = 0;
			} else {
					System.out.println("d_var1: " + d_var1);
					System.out.println("d_var2: " + d_var2);
					System.out.println("operator: " + operator);

					d_total = d_calculate(d_var1, d_var2, operator);
					System.out.println("d_total: " + d_total);
					
					System.out.println("flr: " + Math.floor(d_total));
					System.out.println("isInfinite: " + !Double.isInfinite(d_total ));
		            if ((d_total == Math.floor(d_total )) && !Double.isInfinite(d_total )) {  //check if d_total is the same as floor and that not infinite decimals, if so, this is an integer, else double
		            	total = (int)(d_total);
		            	strTotal = Integer.toString(total);		            	
		            } else { strTotal = Double.toString(d_total); }
	
					numInput.setText(strTotal);
					memberVarReset();
					strVar1 = strTotal;  //assign total to strVar1
					d_var1 = Double.parseDouble(strTotal);  //assign total back to d_var1 for calculation
					System.out.println("d_var1: " + d_var1);
					System.out.println("d_var2: " + d_var2);
			}

//                textField.setText((int)(result) + " ");
//           } else textField.setText(result + " ");
			/*
				else if(operator == "/" && (var1 < var2)){
				if(dec_selected) {
					d_total = d_calculate(d_var1, d_var2, operator);
					System.out.println("d_total: " + d_total);
					
					d_strTotal = Double.toString(d_total);
					numInput.setText(d_strTotal);
					memberVarReset();
					d_var1 = Double.parseDouble(d_strTotal);
				} else {
					if(var1 < var2) {
						d_total = d_calculate(var1, var2, operator);
						d_strTotal = Double.toString(d_total);
						numInput.setText(d_strTotal);
						memberVarReset();
						d_var1 = Double.parseDouble(d_strTotal);
					} else {
						total = calculate(var1, var2, operator);
						System.out.println("total: " + total);
						
						strTotal = Integer.toString(calculate(var1, var2, operator));
						numInput.setText(strTotal);
						memberVarReset();
						var1 = Integer.parseInt(strTotal);	
					}
					*/
//			}

		});

		//Clear Button
		Button clear = new Button("C");  //create number 1 button
		GridPane.setConstraints(clear, 0, 2);  //set number 1 button on grid
		clear.setOnAction(e -> {
			memberVarReset();
			numInput.clear();
		});
		clear.setPrefSize(buttonWidth, buttonHeight);
		
		grid.getChildren().setAll(
				numInput, sq,
				num7, num8, num9, 
				num4, num5, num6, 
				num1, num2, num3, 
				add, sub, mult, 
				div, equal, num0, 
				clear, sq_rt,
				sin, cos, tan);  //place objects into grid
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(grid, 270, 420);  //set up the size of window
		window.setScene(scene);
		window.show(); // Display the stage
	}

}
