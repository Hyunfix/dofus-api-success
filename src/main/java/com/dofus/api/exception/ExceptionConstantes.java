package com.dofus.api.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionConstantes {

    public static Map<String,String> codeMessage;

    static {
        codeMessage = new HashMap<String,String>();
        codeMessage.put("404", "Les succès ne peuvent pas être trouvés");
        codeMessage.put("403","Aucun succès trouvés");
        codeMessage.put("409","Vous n'êtes pas autorisé a récupérer les succès");
    }
    public static final String INTERNAL_ERREUR_MESSAGE = "Internal Error";
    public static final String NOT_FOUND_ERREUR_MESSAGE = "Not found";
    public static final String INTERNAL_EXCEPTION_CODE = "0100";
    public static final String NOT_FOUND_EXCEPTION_CODE = "0200";

}
