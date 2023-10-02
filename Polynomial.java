
import java.io.*;
import java.util.Arrays;

public class Polynomial{
        double [] non_zero;
        int [] exponents;   
        

            
        public int getIndex(int [] exponents, int target){
            for (int i = 0; i < exponents.length; i++){
                if (exponents[i] == target){
                    return i;
                    }
                }
                return -1;
            }
            
            public Polynomial removezero(double[] non_zero, int[] exp, int length){
                int new_length = 0;
                double[] final_non_zero = new double[length];
                int[] final_exp = new int[length];
                for (int i = 0; i < length; i++){
                    if (non_zero[i] != 0){
                        final_non_zero[new_length] = non_zero[i];
                        final_exp[new_length] = exp[i];
                        new_length += 1;
                        }
                    }
                    
                    final_non_zero = Arrays.copyOf(final_non_zero, new_length);
                    final_exp = Arrays.copyOf(final_exp, new_length);
                    
                    return new Polynomial (final_non_zero, final_exp);
                }
            
        public Polynomial(){
            non_zero = new double []{0};
            exponents = new int []{0};
        }
        
        public Polynomial(double [] non, int [] exp){
            this.non_zero = non;
            this.exponents = exp;
        }
        
        public Polynomial (File f) throws IOException{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String p = reader.readLine();
            reader.close();
            
            String[] terms;
            terms = p.split("(?=[+-])");
            
            double [] new_non_zero = new double[terms.length];
            int [] new_exp = new int [terms.length];
            
            for (int i = 0; i < terms.length; i++){
                String t = terms[i];
                int x_index = t.indexOf('x');
                
                if (x_index == -1){
                    new_non_zero[i] = Double.parseDouble(t);
                    new_exp[i] = 0;
                    }
                    else{
                        new_non_zero[i] = Double.parseDouble(t.substring(0,x_index));
                        new_exp[i] = Integer.parseInt(t.substring(x_index + 1));
                        }
                }
                
                this.non_zero = new_non_zero;
                this.exponents = new_exp;
            }
        
        public Polynomial add(Polynomial p){
            
            int length = this.non_zero.length + p.non_zero.length;
            double [] new_non_zero = new double[length];
            int [] new_exp = new int[length];
        
            int i = 0;
            int j = 0;
            int k = 0;
            
            while (i < this.non_zero.length && j < p.non_zero.length){
                    if (this.exponents[i] < p.exponents[j]){
                        new_non_zero[k] = this.non_zero[i];
                        new_exp[k] = this.exponents[i];
                        i++;
                        }
                        else if (this.exponents[i] > p.exponents[j]){
                            new_non_zero[k] = p.non_zero[j];
                            new_exp[k] = p.exponents[j];
                            j++;
                            }
                        else {
                            new_non_zero[k] = this.non_zero[i] + p.non_zero[j];
                            new_exp[k] = this.exponents[i] + p.exponents[j];
                            i++;
                            j++;
                            }
                            k++;
                }
                
                while (i < this.non_zero.length){
                    new_non_zero[k] = this.non_zero[i];
                    new_exp[k] = this.exponents[i];
                    i++;
                    k++;
                    }
                    
                while (j < p.non_zero.length){
                    new_non_zero[k] = p.non_zero[j];
                    new_exp[k] = p.exponents[j];
                    j++;
                    k++;
                    }
                
            return removezero(new_non_zero,new_exp,length);
            

        
        public double evaluate(double x){
            double sum = 0;
           for (int i = 0; i < this.non_zero.length; i++){
                sum += this.non_zero[i]*Math.pow(x,this.exponents[i]);

                }
                return sum;
            }
        
        public boolean hasRoot(double x){
            return (this.evaluate(x) == 0);
        }

        
        public Polynomial multiply(Polynomial p){
            int length = this.non_zero.length*p.non_zero.length;
            double[] new_coeff = new double[length];
            int[] new_exp = new int[length];
            int index = 0;
            
            for (int i = 0; i < this.non_zero.length;i++){
                for (int j = 0; j < p.non_zero.length;j++){
                    double coeff = this.non_zero[i] * p.non_zero[j];
                    int exponent = this.exponents[i] + p.exponents[j];
                    
                    boolean isFound = false;
                    for (int k = 0; k < index; k++){
                        if (new_exp[k] == exponent){
                            new_coeff[k] += coeff;
                            isFound = true;
                            break;
                        }
                    }
                    if (isFound == false){
                        new_coeff[index] = coeff;
                        new_exp[index] = exponent;
                        index++;
                        }
                   } 
                }
    
                return removezero(new_coeff,new_exp,length);
            
            }
            
        public void saveToFile(String file) throws IOException {
            BufferedWriter write = new BufferedWriter(new FileWriter(file));
            
            boolean isFirst = true;
            
            for (int i = 0; i < this.non_zero.length; i++){
                if (this.non_zero[i] != 0){
                    if (!isFirst){
                        write.write(this.non_zero[i] > 0 ? "+" : "-");
                        }else {
                            isFirst = false;
                            }
                            write.write(Double.toString(Math.abs(this.non_zero[i])));
                            
                            if (this.exponents[i] > 0) {
                                write.write("x" + this.exponents[i]);
                                }
                    }
                }
                write.close();
            }
        
        

    }