<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" href="//cdn.datatables.net/2.1.8/css/dataTables.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
<script src="//cdn.datatables.net/2.1.8/js/dataTables.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#prestamosAprobados').DataTable();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#prestamosRechazados').DataTable();
	});
</script>
<title>Gesti�n de Prestamos</title>
</head>
<body>

<%-- Incluir el men� de navegaci�n desde nav.jsp --%>
<jsp:include page="nav.jsp" />
<div class="management-container">
    <h1>Gestion Prestamos</h1>
    <br>
    <h2>Prestamos pendientes de aprobaci�n</h2>
    <div class="filter-container">
        <div class="filter-option">
            <input type="checkbox" id="filterByDatePendientes" />
            <label for="filterByDate">Filtrar por rango de fechas</label>
            <div id="dateFilterPendientes" class="filter-inputs" style="display: none;">
                <label for="startDate">Desde:</label>
                <input type="date" id="startDate" />
                <label for="endDate">Hasta:</label>
                <input type="date" id="endDate" />
            </div>
        </div>

        <div class="filter-option">
            <input type="checkbox" id="filterByAmountPendientes" />
            <label for="filterByAmount">Filtrar por rango de montos</label>
            <div id="amountFilterPendientes" class="filter-inputs" style="display: none;">
                <label for="minAmount">M�nimo:</label>
                <input type="number" id="minAmount" placeholder="$0" />
                <label for="maxAmount">M�ximo:</label>
                <input type="number" id="maxAmount" placeholder="$1,000,000" />
            </div>
        </div>
        
        <button id="applyFiltersPendientes" class="btn-apply">Aplicar Filtros</button>
    </div>
    <table id="prestamosPendientes" class="account-table display">
        <thead>
            <tr>
                <th>Cliente</th>
                <th>Monto</th>
                <th>Cuotas</th>
                <th>Fecha de solicitud</th>
                <th>Tipo de Cuenta</th> 
                <th>Aprobar</th>
                <th>Rechazar</th>               
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Carlos Gonzalez</td>
                <td>$ 1.000.000,02.-</td>
                <td>6</td>
                <td>2024-10-30</td>
                <td>Corriente</td>
                <td><a href="AprobarPrestamo.jsp?prestamoId=123456789" class="btn-aprobar">Aprobar</a></td>
                <td><a href="RechazarPrestamo.jsp?prestamoId=123456789" class="btn-rechazar">Rechazar</a></td>
            </tr>
            <tr>
                <td>Carla Rodriguez</td>
                <td>$ 890.000,00.-</td>
                <td>24</td>
                <td>2024-10-22</td>
                <td>Corriente</td>
                <td><a href="AprobarPrestamo.jsp?prestamoId=123456789" class="btn-aprobar">Aprobar</a></td>
                <td><a href="RechazarPrestamo.jsp?prestamoId=123456789" class="btn-rechazar">Rechazar</a></td>
            </tr>
            
        </tbody>
    </table>
    <br>
    <h2>Prestamos aprobados</h2>
    <div class="filter-container">
        <div class="filter-option">
            <input type="checkbox" id="filterByDateAprobados" />
            <label for="filterByDate">Filtrar por rango de fechas</label>
            <div id="dateFilterAprobados" class="filter-inputs" style="display: none;">
                <label for="startDate">Desde:</label>
                <input type="date" id="startDate" />
                <label for="endDate">Hasta:</label>
                <input type="date" id="endDate" />
            </div>
        </div>

        <div class="filter-option">
            <input type="checkbox" id="filterByAmountAprobados" />
            <label for="filterByAmount">Filtrar por rango de montos</label>
            <div id="amountFilterAprobados" class="filter-inputs" style="display: none;">
                <label for="minAmount">M�nimo:</label>
                <input type="number" id="minAmount" placeholder="$0" />
                <label for="maxAmount">M�ximo:</label>
                <input type="number" id="maxAmount" placeholder="$1,000,000" />
            </div>
        </div>
        
        <button id="applyFiltersAprobados" class="btn-apply">Aplicar Filtros</button>
    </div>
    <table id="prestamosAprobados" class="account-table display">
        <thead>
            <tr>
                <th>Cliente</th>
                <th>Monto</th>
                <th>Cuotas</th>
                <th>Fecha de solicitud</th>
                <th>Tipo de Cuenta</th> 
                <th>Detalle</th>             
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Carlos Gonzalez</td>
                <td>$ 1.000.000,02.-</td>
                <td>6</td>
                <td>2024-10-30</td>
                <td>Corriente</td>
                <td><a href="AprobarPrestamo.jsp?prestamoId=123456789" class="btn-Detalle">Detalle</a></td>
            </tr>
            <tr>
                <td>Carla Rodriguez</td>
                <td>$ 890.000,00.-</td>
                <td>24</td>
                <td>2024-10-22</td>
                <td>Corriente</td>
                <td><a href="AprobarPrestamo.jsp?prestamoId=123456789" class="btn-Detalle">Detalle</a></td>
            </tr>
            
        </tbody>
    </table>
    <br>
     <h2>Prestamos rechazados</h2>
     
     <div class="filter-container">
        <div class="filter-option">
            <input type="checkbox" id="filterByDateRechazados" />
            <label for="filterByDate">Filtrar por rango de fechas</label>
            <div id="dateFilterRechazados" class="filter-inputs" style="display: none;">
                <label for="startDate">Desde:</label>
                <input type="date" id="startDate" />
                <label for="endDate">Hasta:</label>
                <input type="date" id="endDate" />
            </div>
        </div>

        <div class="filter-option">
            <input type="checkbox" id="filterByAmountRechazados" />
            <label for="filterByAmount">Filtrar por rango de montos</label>
            <div id="amountFilterRechazados" class="filter-inputs" style="display: none;">
                <label for="minAmount">M�nimo:</label>
                <input type="number" id="minAmount" placeholder="$0" />
                <label for="maxAmount">M�ximo:</label>
                <input type="number" id="maxAmount" placeholder="$1,000,000" />
            </div>
        </div>
        
        <button id="applyFiltersRechazados" class="btn-apply">Aplicar Filtros</button>
    </div>
    <table id="prestamosRechazados" class="account-table display">
        <thead>
            <tr>
                <th>Cliente</th>
                <th>Monto</th>
                <th>Cuotas</th>
                <th>Fecha de solicitud</th>
                <th>Tipo de Cuenta</th> 
                <th>Detalle</th>             
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>Carlos Gonzalez</td>
                <td>$ 1.000.000,02.-</td>
                <td>6</td>
                <td>2024-10-30</td>
                <td>Corriente</td>
                <td><a href="AprobarPrestamo.jsp?prestamoId=123456789" class="btn-Detalle">Detalle</a></td>
            </tr>
            <tr>
                <td>Carla Rodriguez</td>
                <td>$ 890.000,00.-</td>
                <td>24</td>
                <td>2024-10-22</td>
                <td>Corriente</td>
                <td><a href="AprobarPrestamo.jsp?prestamoId=123456789" class="btn-Detalle">Detalle</a></td>
            </tr>
            
        </tbody>
    </table>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#prestamosRechazados').DataTable();
		 // Mostrar u ocultar filtros
        $('#filterByDatePendientes').change(function() {
            $('#dateFilterPendientes').toggle(this.checked);
        });

        $('#filterByAmountPendientes').change(function() {
            $('#amountFilterPendientes').toggle(this.checked);
        });

        // L�gica de aplicar filtros (solo front-end, sin interacci�n con backend)
        $('#applyFiltersPendientes').click(function() {
            // Aqu� puedes a�adir la l�gica para filtrar los datos en la tabla
            alert('Filtros aplicados. Esto es solo el front-end.');
        });
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#prestamosAprobados').DataTable();
		 // Mostrar u ocultar filtros
        $('#filterByDateAprobados').change(function() {
            $('#dateFilterAprobados').toggle(this.checked);
        });

        $('#filterByAmountAprobados').change(function() {
            $('#amountFilterAprobados').toggle(this.checked);
        });

        // L�gica de aplicar filtros (solo front-end, sin interacci�n con backend)
        $('#applyFiltersAprobados').click(function() {
            // Aqu� puedes a�adir la l�gica para filtrar los datos en la tabla
            alert('Filtros aplicados. Esto es solo el front-end.');
        });
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#prestamosRechazados').DataTable();
		 // Mostrar u ocultar filtros
        $('#filterByDateRechazados').change(function() {
            $('#dateFilterRechazados').toggle(this.checked);
        });

        $('#filterByAmountRechazados').change(function() {
            $('#amountFilterRechazados').toggle(this.checked);
        });

        // L�gica de aplicar filtros (solo front-end, sin interacci�n con backend)
        $('#applyFiltersRechazados').click(function() {
            // Aqu� puedes a�adir la l�gica para filtrar los datos en la tabla
            alert('Filtros aplicados. Esto es solo el front-end.');
        });
	});
</script>
</body>
</html>