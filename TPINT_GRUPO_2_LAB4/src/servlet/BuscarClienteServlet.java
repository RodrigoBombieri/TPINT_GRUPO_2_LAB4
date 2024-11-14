package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import entidades.Cliente;
import negocioImpl.ClienteNegocioImpl;

/**
 * Servlet implementation class BuscarClienteServlet
 */
@WebServlet("/BuscarClienteServlet")
public class BuscarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int clienteId = Integer.parseInt(request.getParameter("clienteId"));
    	String action = request.getParameter("action");
        ClienteNegocioImpl auxClienteNeg = new ClienteNegocioImpl();
        Cliente cliente = auxClienteNeg.obtenerClientePorId(clienteId);
        if (cliente == null) {
            // Si el cliente no existe redirecciono.
			System.out.println("El cliente no existe.");
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } else {
            request.setAttribute("cliente", cliente);
            if ("editarCliente".equals(action)) {
                request.getRequestDispatcher("EditarCliente.jsp").forward(request, response);
            } else if ("agregarCuenta".equals(action)) {
            	request.setAttribute("fechaHoy", LocalDate.now().toString());
                request.getRequestDispatcher("/CargarDesplegablesServlet").forward(request, response);
            } else if ("editarCuenta".equals(action)) {
                request.getRequestDispatcher("/CargarDesplegablesServlet").forward(request, response);     
            }else {
                // Si `action` no coincide con ninguna acci�n esperada, redirige a una p�gina por defecto.
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
