/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chebyshev;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.awt.*;

/**
 *
 * @author pedja
 */
public class ChebyshevGUI extends javax.swing.JFrame {

    /**
     * Creates new form ProtomaticGUI
     */
    public ChebyshevGUI() {
        initComponents();
        setIcon();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numberLabel = new javax.swing.JLabel();
        numberTextField = new javax.swing.JTextField();
        checkButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chebyshev");
        setResizable(false);

        numberLabel.setText("Number:");

        checkButton.setText("Check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        resultLabel.setMaximumSize(new java.awt.Dimension(108, 17));
        resultLabel.setMinimumSize(new java.awt.Dimension(108, 17));
        resultLabel.setPreferredSize(new java.awt.Dimension(108, 17));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numberLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {checkButton, clearButton, closeButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkButton)
                    .addComponent(clearButton)
                    .addComponent(closeButton))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {numberLabel, numberTextField});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        // TODO add your handling code here:
        Object source =evt.getSource();
		 if (source.equals(checkButton))
		 {
        try{
        BigInteger n,m;
        BigDecimal bd;
        int r;
        resultLabel.setText("");
        String expression = numberTextField.getText();
        
        
        
    	
        Protomatic protomatic = new Protomatic();
        bd = protomatic.eval(expression);
        if (bd.remainder( BigDecimal.ONE ).equals(BigDecimal.ZERO))
        {
            n=bd.toBigInteger();
            m=n;
       
        if(m.compareTo(BigInteger.valueOf(2))==-1)
        {
        JOptionPane.showMessageDialog(null, "Number must be greater than one!");
        numberTextField.setText("");
           
        }
        else if(m.equals(BigInteger.valueOf(2))) {
           resultLabel.setText("Prime!");
        }
        else {
            
             r=3;
        while(m.mod(BigInteger.valueOf(r)).equals(BigInteger.ZERO) || m.modPow(BigInteger.valueOf(2),BigInteger.valueOf(r)).equals(BigInteger.ONE) ) {
          r=protomatic.nextPrime(r);
          
        }
        
        if(protomatic.isprime(n,m,r))
        {
        resultLabel.setText("Prime!");
        
        }
        else {
          resultLabel.setText("Composite!");
          
        }
        }
        }
        else {
         JOptionPane.showMessageDialog(null, "Invalid entry!");
        numberTextField.setText("");    
        }
        }
        catch(Exception e) {
         JOptionPane.showMessageDialog(null, "Invalid entry!");
        numberTextField.setText("");   
        }
    
                 }
    }//GEN-LAST:event_checkButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        numberTextField.setText("");
        resultLabel.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed
static class Protomatic {
    
    static class Poly {

	BigInteger [] monos;
	int degree;
	
	/**
	 * Set all coefficients and degree to zero
	 * 
	 * @param p
	 */
	static void zero(Poly p)
	{
		for( int i = 0; i < p.monos.length; i++ )
			p.monos[i] = BigInteger.ZERO;
		
		p.degree = 0;
	}
	
	/**
	 * Debugging method
	 */
	void printMonos()
	{
		for( int i = 0; i <= this.degree; i++ )
			System.out.println(this.monos[i]);
	}
	
	/**
	 * Create the zero polynomial
	 */
	public Poly()
	{
		this.monos = new BigInteger[10];
		zero(this);
	}

	/**
	 * Create a zero polynomial with 
	 * a coefficient array of a given size
	 * 
	 * @param size
	 */
	public Poly(int size)
	{
		this.monos = new BigInteger[size+1];
		zero(this);
	}
	
	/**
	 * Clone a polynomial
	 * 
	 * @param p
	 */
	public Poly(Poly p)
	{
		this.degree = p.degree;
		this.monos = Arrays.copyOf(p.monos, p.monos.length);
	}
	
	/**
	 * Create a one-term polynomial
	 * @param coeff coefficient
	 * @param exp exponent
	 */
	public Poly( BigInteger coeff, int exp )
	{
		this(exp);
		if (coeff.compareTo(BigInteger.ZERO) != 0)
		{
			monos[exp] = coeff;
			degree = exp;
		}
	}
	
	/**
	 * Degree of the polynomial
	 * @return degree of the polynomial
	 */
	public int degree()
	{
		return this.degree;
	}

	/**
	 * Obtain coefficient for a given term of
	 * the polynomial
	 * 
	 * @param d
	 * @return coefficient for the term of given degree
	 */
	public BigInteger coefficient(int d)
	{
		return this.monos[d];
	}
	
	/**
	 * String representation of polynomial
	 */
	public String toString()
	{
		String s = "";
		for( int i = this.degree; i >= 1; i-- )
			if( monos[i].compareTo(BigInteger.ZERO) != 0 ) 
				s += (monos[i].compareTo(BigInteger.ONE) == 0 ? "" : monos[i])
						+ "x^" + i + " + ";
		
		if ( monos[0].compareTo(BigInteger.ZERO) !=0 )
			s += monos[0] + " + ";

		return s == "" ? "0" : s.substring(0,s.length()-3);
	}

	@Override
	/***
	 * Implement an equals method
	 * 
	 * @returns true if the two objects are the same
	 */
	public boolean equals(Object p)
	{
		if (p == null) return false;
	    if (p == this) return true;
	    if (this.getClass() != p.getClass()) return false;
	    
	    if( this.degree != ((Poly) p).degree )
			return false;
		
		for( int i = 0; i <= degree; i++ )
			if( this.monos[i].compareTo(((Poly) p).monos[i]) != 0 )
				return false;
		
		return true;
	}

	/**
	 * Add two polynomials together
	 * 
	 * @param p
	 * @return the sum of this and p
	 */
	public Poly plus(Poly p)
	{
		int maxDegree = Math.max(this.degree, p.degree);
		
		Poly sum = new Poly(maxDegree);
		sum.degree = maxDegree;
		
		for( int i = 0; i <= maxDegree; i++ )
			sum.monos[i] = (i <= this.degree && i <= p.degree) ? p.monos[i].add(this.monos[i]) :
				(i > this.degree) ? p.monos[i] : this.monos[i];
		
		return sum;
	}
	
	/***
	 * Subtract two polynomials
	 * 
	 * @param p
	 * @return this minus p
	 */
	public Poly minus(Poly p)
	{
		int maxDegree = Math.max(this.degree, p.degree);
		
		Poly difference = new Poly(maxDegree);
		difference.degree = maxDegree;
		
		for( int i = 0; i <= maxDegree; i++ )
			difference.monos[i] = (i <= this.degree && i <= p.degree) ? this.monos[i].subtract(p.monos[i]) :
				(i > this.degree) ? p.monos[i].negate() : this.monos[i];

		updateDegree(difference);
		return difference;
	}
	
	/**
	 * Synchronize the degree of the polynomial
	 * with the coefficient array length and coefficient
	 * values
	 * 
	 * @param p
	 */
	static void updateDegree(Poly p)
	{
		p.degree = p.monos.length - 1;
		
		while( p.monos[p.degree].compareTo(BigInteger.ZERO) == 0 && p.degree > 0 )
			p.degree--;
	}
	
	/**
	 * Multiply all coefficients by b
	 * 
	 * @param b
	 * @return b*this
	 */
	public Poly times(BigInteger b)
	{
		Poly product = new Poly(this);

		for( int i = 0; i <= product.degree; i++ )
			product.monos[i] = product.monos[i].multiply(b);
		
		return product;
	}
	
	/**
	 * Multiply this with another polynomial
	 * 
	 * @param p
	 * @return this*p
	 */
	public Poly times(Poly p)
	{
        Poly product = new Poly(this.degree+p.degree);
        product.degree = this.degree + p.degree;
        
        for( int i = 0; i <= this.degree; i++ )
        {
        	for( int j = 0; j <= p.degree; j++ )
                product.monos[i+j] = product.monos[i+j].add(this.monos[i].multiply(p.monos[j]));
        }

        return product;
	}
	
	/**
	 * Mod all of the coefficients by m
	 * 
	 * @param m
	 * @return this mod m
	 */
	public Poly mod(BigInteger m)
	{
		Poly remainder = new Poly(this);
		
		for( int i = 0; i <= remainder.degree; i++ )
			remainder.monos[i] = monos[i].mod(m);

		updateDegree(remainder);
		
		return remainder;
	}

	/**
	 * Mod this by a polynomial of the form x^e + a
	 * 
	 * @param m
	 * @return
	 */
	public Poly mod(Poly m)
	{
		Poly remainder = new Poly(this);

		while( remainder.degree >= m.degree )
		{
			int diff = remainder.degree - m.degree;
			Poly sub = new Poly(m).times(new Poly(remainder.coefficient(remainder.degree), diff));
			// System.out.println("sub = " + sub);
			remainder = remainder.minus(sub);
		}

		return remainder;
	}
	
	/***
	 * Exponentiate a polynomial with the coefficients mod a constant
	 * and the polynomial mod another polynomial
	 * 
	 * @param exponent
	 * @param mPoly
	 * @param mBigInteger
	 * @return this^exponent (mod mBigInteger, mPoly)
	 */
	public Poly modPow(BigInteger exponent, Poly mPoly, BigInteger mBigInteger)
	{
		
		int maxBits = exponent.bitLength();

		Poly answer = new Poly(BigInteger.ONE,0);
		for( int bit = 0; bit < maxBits; bit++ )
		{
			// explicitly break apart the multiplication and modulus
			answer = answer.times(answer);
			answer = answer.mod(mPoly);
			answer = answer.mod(mBigInteger);
			
			// Consider bits from left to right
			// if the bit is set multiply by this
			if( exponent.testBit(maxBits - bit - 1) )
			{
				// explicitly break apart the multiplication and modulus
				answer = answer.times(this);
				answer = answer.mod(mPoly);
				answer = answer.mod(mBigInteger);
			}
				
		}
			
		return answer;
	}
	

    }
    
    static boolean isprime(BigInteger n,BigInteger m,int r) 
    {
    Poly p8 = new Poly(BigInteger.ONE,1);
    
    Poly p0 = new Poly(BigInteger.valueOf(2),1);
    Poly p1 = new Poly(BigInteger.ONE.negate(),0);
    Poly p5 = new Poly(BigInteger.ONE,0);
    Poly p6 = new Poly(BigInteger.ZERO,0);
    
    
    Poly p2 = new Poly(BigInteger.ONE,r);
    Poly p3 = new Poly(BigInteger.ONE,0);
    Poly p4= p2.minus(p3);
    
    Poly F[][] = new Poly[][]{{p0.mod(p4).mod(m),p1.mod(p4).mod(m)},{p5.mod(p4).mod(m),p6.mod(p4).mod(m)}}; 
    
    expBySquaring(F,n.subtract(BigInteger.ONE),m,r); 
    multiply2(F,m,r);
      
       return(F[0][0].equals(p8.modPow(n,p4,n))); 
    
    } 
    
    static void  multiply(Poly F[][], Poly M[][],BigInteger m,int r) 
    { 
        
    Poly p2 = new Poly(BigInteger.ONE,r);
    Poly p3 = new Poly(BigInteger.ONE,0);
    Poly p4= p2.minus(p3);
    
    
    Poly x =  (F[0][0].times(M[0][0])).plus(F[0][1].times(M[1][0])); 
    Poly y =  (F[0][0].times(M[0][1])).plus(F[0][1].times(M[1][1])); 
    Poly z =  (F[1][0].times(M[0][0])).plus(F[1][1].times(M[1][0]));
    Poly w =  (F[1][0].times(M[0][1])).plus(F[1][1].times(M[1][1]));
    
     
    
    F[0][0] = x.mod(p4).mod(m); 
    F[0][1] = y.mod(p4).mod(m); 
    F[1][0] = z.mod(p4).mod(m); 
    F[1][1] = w.mod(p4).mod(m);
    
    
    } 
    
    static void multiply2(Poly F[][],BigInteger m,int r) 
    {
    Poly p0 = new Poly(BigInteger.ONE,1);
    Poly p1 = new Poly(BigInteger.ONE,0);
    
    Poly p2 = new Poly(BigInteger.ONE,r);
    Poly p3 = new Poly(BigInteger.ONE,0);
    Poly p4= p2.minus(p3);
    
    Poly x =  (F[0][0].times(p0)).plus(F[0][1].times(p1)); 
    Poly y =  (F[1][0].times(p0)).plus(F[1][1].times(p1)); 
   
       
    F[0][0] = x.mod(p4).mod(m);
    F[0][1] = y.mod(p4).mod(m); 
    
    
    } 
    
    
    static void expBySquaring(Poly F[][], BigInteger n,BigInteger m,int r)
            {
                
    Poly p0 = new Poly(BigInteger.valueOf(2),1);
    Poly p1 = new Poly(BigInteger.ONE.negate(),0);
    Poly p5 = new Poly(BigInteger.ONE,0);
    Poly p6 = new Poly(BigInteger.ZERO,0);
    
    
    Poly p2 = new Poly(BigInteger.ONE,r);
    Poly p3 = new Poly(BigInteger.ONE,0);
    Poly p4= p2.minus(p3);
      
    if( n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))          
       return; 
    Poly M[][] = new Poly[][]{{p0.mod(p4).mod(m),p1.mod(p4).mod(m)},{p5.mod(p4).mod(m),p6.mod(p4).mod(m)}};  
     expBySquaring(F,n.shiftRight(1),m,r);
     multiply(F,F,m,r);
     if(n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
     multiply(F, M,m,r);
    }
    
      static int nextPrime(int input){
  int counter;
  input++;
  while(true){
    int l = (int) Math.sqrt(input);
    counter = 0;
    for(int i = 2; i <= l; i ++){
      if(input % i == 0)  counter++;
    }
    if(counter == 0)
      return input;
    else{
      input++;
      continue;
    }
  }
}
      
      public static BigDecimal eval(final String str) {
    return new Object() {
        int pos = -1, ch;

        void nextChar() {
            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
        }

        boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        BigDecimal parse() {
            nextChar();
            BigDecimal x = parseExpression();
            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }

        // Grammar:
        // expression = term | expression `+` term | expression `-` term
        // term = factor | term `*` factor | term `/` factor
        // factor = `+` factor | `-` factor | `(` expression `)`
        //        | number | functionName factor | factor `^` factor

        BigDecimal parseExpression() {
            BigDecimal x = parseTerm();
            for (;;) {
                if      (eat('+')) x=x.add(parseTerm()); // addition
                else if (eat('-')) x=x.subtract(parseTerm()); // subtraction
                else return x;
            }
           }

        BigDecimal parseTerm() {
            BigDecimal x = parseFactor();
            for (;;) {
                if      (eat('*')) x=x.multiply(parseFactor()); // multiplication
                else if (eat('/')) x=x.divide(parseFactor()); // division
                else return x;
            }
        }

        BigDecimal parseFactor() {
            if (eat('+')) return parseFactor(); // unary plus
            if (eat('-')) return parseFactor().negate(); // unary minus

            BigDecimal x;
            int startPos = this.pos;
            if (eat('(')) { // parentheses
                x = parseExpression();
               if (!eat(')'))
               {
                throw new RuntimeException("Unexpected: " + (char)ch);   
               }
            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = new BigDecimal(str.substring(startPos, this.pos));
            }  else {
                throw new RuntimeException("Unexpected: " + (char)ch);
            }

            if (eat('^')) x =x.pow(parseFactor().intValue()); // exponentiation

            return x;
        }
    }.parse();
}
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChebyshevGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChebyshevGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChebyshevGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChebyshevGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChebyshevGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JLabel resultLabel;
    // End of variables declaration//GEN-END:variables
private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Chebyshev.png")));
    }
}
