package mvcCalculoAprovacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/aprovacao");
public class calculoAprovacaoController extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
    String nome = req.getParameter("nome");
    String frequenciaStr = req.getParameter("frequencia");
    float frequencia = frequenciaStr == null || frequenciaStr.isEmpty() ? 0 : Float.parseFloat(frequenciaStr);
    String notafinalStr = req.getParameter("notaFinal");
    float notafinal = notafinalStr == null || notafinalStr.isEmpty() ? 0 : Float.parseFloat(notafinalStr);
    String resultado;
    if(notafinal =!null || frequenciaStr=!null)
      resultado = calculoAprovacaoModel.resultado(frequencia, notafinal);
    else resultado="Por favor, passse os dados correto!";
    System.out.println(resultado);
    req.setAttribute("resultado", resultado);

    String nextJsp = "/index.jsp";
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJsp);
    dispatcher.forward(req, resp);
  }
}