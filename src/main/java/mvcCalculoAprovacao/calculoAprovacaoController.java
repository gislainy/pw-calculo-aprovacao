package mvcCalculoAprovacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/aprovacao")
public class calculoAprovacaoController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    String nome = req.getParameter("nome");
    String frequenciaStr = req.getParameter("frequencia");
    Float frequencia = frequenciaStr == null || frequenciaStr.isEmpty() ? 0 : Float.parseFloat(frequenciaStr);
    String notafinalStr = req.getParameter("notaFinal");
    Float notafinal = notafinalStr == null || notafinalStr.isEmpty() ? 0 : Float.parseFloat(notafinalStr);
    String resultado;
    if(nome != null && notafinal != null && frequencia !=  null && notafinal != 0 && frequencia != 0){
      resultado = calculoAprovacaoModel.resultado(frequencia, notafinal);
      req.setAttribute("resultado", (nome!=null ? nome + " foi "  : " - " )+resultado);
      String tipoDeMensagem = calculoAprovacaoModel.tipoDeMensagem(resultado);
      req.setAttribute("tipoDeMensagem", tipoDeMensagem);
      req.setAttribute("tituloMensagem", "Resultado");
    }
    else {
      resultado="Por favor, passse os dados correto!";
      req.setAttribute("resultado", resultado);
      req.setAttribute("tipoDeMensagem", "warning");
      req.setAttribute("tituloMensagem", "Erro");
    }
    String nextJsp = "/index.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
    dispatcher.forward(req, resp);
  }
}