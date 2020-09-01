/**
 * Algoritmo de ordenacao Mergesort
 * @author Max do Val Machado
 * @version 3 08/2020
 */
class Mergesort extends Geracao {

   /**
    * Construtor.
    */
   public Mergesort(){
      super();
   }


   /**
    * Construtor.
    * @param int tamanho do array de numeros inteiros.
    */
   public Mergesort(int tamanho){
      super(tamanho);
   }


   /**
    * Algoritmo de ordenacao Mergesort.
    */
   @Override
   public void sort() {
      mergesort(0, n-1);
   }

   /**
    * Algoritmo de ordenacao Mergesort.
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
    */
   private void mergesort(int esq, int dir) {
      if (esq < dir){
         int meio = (esq + dir) / 2;
         mergesort(esq, meio);
         mergesort(meio + 1, dir);
         intercalar(esq, meio, dir);
      }
   }

   /**
    * Algoritmo que intercala os elementos entre as posicoes esq e dir
    * @param int esq inicio do array a ser ordenado
    * @param int meio posicao do meio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
    */ 
   public void intercalar(int esq, int meio, int dir){

      //Definir tamanho dos dois subarrays
      int nEsq = (meio+1)-esq;
      int nDir = dir - meio;

      int[] arrayEsq = new int[nEsq+1];
      int[] arrayDir = new int[nDir+1];

      //Sentinela no final dos dois arrays
      arrayEsq[iEsq] = arrayDir[iDir] = 0x7FFFFFFF;

      int iEsq, iDir, i;

      //Inicializar primeiro subarray
      for(iEsq = 0; iEsq < nEsq; iEsq++){
         arrayEsq[iEsq] = array[esq+iEsq];
      }

      //Inicializar segundo subarray
      for(iDir = 0; iDir < nDir; iDir++){
         arrayDir[iDir] = array[(meio+1)+iDir];
      }

      //Intercalacao propriamente dita
      for(iEsq = iDir = 0, i = esq; i <= dir; i++){
         array[i] = (arrayEsq[iEsq] <= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
      }
   }
}
