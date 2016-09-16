package mvcCalculoAprovacao;

public class calculoAprovacaoModel {
    public static String resultado(float frequencia, float notafinal){
        String result = "";
        boolean aprovadoPorNota = false;
        boolean aprovadoPorFrequencia = false;
        if(notafinal > 6.0)
            aprovadoPorNota = true;
        if(frequencia > 75.00)
            aprovadoPorFrequencia = true;
        if(aprovadoPorNota && aprovadoPorFrequencia)
            result = "Aprovado";
        else if(aprovadoPorNota)
            result = "Reprovado por frequência";
        else 
            result = "Reprovado por nota e frequência";
        return result;
    }
}