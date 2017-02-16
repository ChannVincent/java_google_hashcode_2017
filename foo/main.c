//
//  main.c
//  foo
//
//  Created by Vincent Chann on 13/02/2017.
//  Copyright © 2017 Smartapps. All rights reserved.
//

#include <stdio.h>

int nbLignes;
int nbColones;

void checkAllCells(int (*tab)[nbLignes][nbColones], int nbMin){
    
    int i = 0;
    int j = 0;
    
    int k =0;
    
    int tmp = 0;
    
    int slice[nbMin];
    
    for(i = 0; i<nbLignes; i++){
        for(j=0; j<nbColones; j++){
            
            int p = *tab[i][j];
            slice[tmp] = p;
            
            printf("coucou %d", p);
            
            if(tmp == 2*nbMin-1){
                //tmp = 0;
                for(k=0; k<2*nbMin;k++){
                    printf("%d", slice[k]);
                }
            }
            
            tmp++;
            
        }
    }
    
}


void readFile(){
    FILE* fichier = NULL;
    
    fichier = fopen("/Users/cdurif/Desktop/small.txt", "r");
    
    if (fichier != NULL)
    {
        int nbLignes;
        int nbColones;
        int nbMin;
        int nbMax;
        
        int nbTomates = 0;
        int nbChampis = 0;
        
        fscanf(fichier, "%d %d %d %d", &nbLignes, &nbColones, &nbMin, &nbMax);
        
        printf("Nombre de lignes : %d\n", nbLignes);
        printf("Nombre de colonnes : %d\n", nbColones);
        printf("Nombre minimum de chaque ingrédient : %d\n", nbMin);
        printf("Nombre maximal de cases par part : %d\n", nbMax);
        
        int tab[nbLignes][nbColones];
        
        int i = 0;
        int j = 0;
        for(i=0; i<nbLignes; i++){
            for(j=0;j<nbColones;j++){
                char x = fgetc(fichier);
                
                if(x == '\n'){
                    x = fgetc(fichier);
                }
                
                int t = 4;
                if(x == 'T'){
                    t = 0;
                    nbTomates++;
                }
                else if(x == 'M'){
                    t = 1;
                    nbChampis++;
                }
                else{
                    
                }
                tab[i][j] = t;
            }
        }
        
        printf("La pizza contient %d tomates.\n", nbTomates);
        printf("La pizza contient %d champignons.\n", nbChampis);

        
        for(i=0; i<nbLignes; i++){
            for(j=0;j<nbColones;j++){
                printf("%d", tab[i][j]);
                if(j == nbColones-1){
                    printf("\n");
                }
            }
        }
        
        
        fclose(fichier);
        
        int ii = 0;
        int jj = 0;
        
        int k =0;
        
        int tmp = 0;
        
        int slice[nbMin];
        
        for(ii = 0; ii<nbLignes; ii++){
            for(jj=0; jj<nbColones; jj++){
                
                int p = tab[ii][jj];
                slice[tmp] = p;
                
                if(tmp == 2*nbMin-1){
                    //tmp = 0;
                    for(k=0; k<2*nbMin;k++){
                        printf("%d", slice[k]);
                    }
                }
                
                tmp++;
                
            }
        }
    }
    

}


int main(int argc, const char * argv[]) {
    readFile();
    return 0;
}
