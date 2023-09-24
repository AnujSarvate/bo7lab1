public class Polynomial{
        double [] co;
            
        public Polynomial(){
            co = new double []{0};
        }
        
        public Polynomial(double [] c){
            this.co = c;
        }
        
        public Polynomial add(Polynomial p){
            
            Polynomial temp = new Polynomial();
            
            if (this.co.length > p.co.length){
                temp.co = this.co;
                for (int i = 0; i < p.co.length;i++){
                    temp.co[i] = p.co[i] + this.co[i];
            }
        }
        else {
            temp.co = p.co;
            for (int i = 0; i < this.co.length; i++){
                temp.co[i] = p.co[i] + this.co[i];
                }
            }  
            return temp;
        }
        
        public double evaluate(double x){
            double sum = 0;
            for (int i = 0; i < this.co.length; i++){
                sum += this.co[i]*Math.pow(x,i);
                }
                return sum;
            }
        
        public boolean hasRoot(double x){
            return (this.evaluate(x) == 0);
        }
    }