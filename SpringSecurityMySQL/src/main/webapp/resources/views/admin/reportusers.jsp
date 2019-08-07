
<!-- Container (Pricing Section) -->
<div class="container-fluid">
    <h2 class="text-center">REPORTES DE USUARIOS</h2>
  <div class="row slideanim">
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-info text-center">
        <div class="panel-heading">
          <h3>TODOS LOS USUARIOS</h3>
        </div>
        <div class="panel-body">
          <p>Generar reporte PDF/EXCEL de todos los usuarios.</p>
        </div>
        <div class="panel-footer">
          <button class="btn btn-lg btn-danger btn-block" ng-click="generar_report_users('all','pdf')"><i class="fa fa-file-pdf-o" aria-hidden="true"></i> PDF</button>
          <button class="btn btn-lg btn-success btn-block"  ng-click="generar_report_users('all','xlsx')"><i class="fa fa-file-excel-o" aria-hidden="true"></i> EXCEL</button>          
        </div>
      </div>      
    </div>     
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-info text-center">
        <div class="panel-heading">
          <h3>USUARIOS ACTIVOS</h3>
        </div>
        <div class="panel-body">
          <p>Generar reporte PDF/EXCEL de los usuarios activos.</p>
        </div>
        <div class="panel-footer">
          <button class="btn btn-lg btn-danger btn-block"  ng-click="generar_report_users('activos','pdf')"><i class="fa fa-file-pdf-o" aria-hidden="true"></i> PDF</button>   
          <button class="btn btn-lg btn-success btn-block"  ng-click="generar_report_users('activos','xlsx')"><i class="fa fa-file-excel-o" aria-hidden="true"></i> EXCEL</button>       
        </div>
      </div>      
    </div>       
    <div class="col-sm-4 col-xs-12">
      <div class="panel panel-info text-center">
        <div class="panel-heading">
          <h3>USUARIOS INACTIVOS</h3>
        </div>
        <div class="panel-body">
          <p>Generar reporte PDF/EXCEL de los usuarios inactivos.</p>
        </div>
        <div class="panel-footer">
          <button class="btn btn-lg btn-danger btn-block" ng-click="generar_report_users('inactivos','pdf')"><i class="fa fa-file-pdf-o" aria-hidden="true"></i> PDF</button>   
          <button class="btn btn-lg btn-success btn-block"   ng-click="generar_report_users('inactivos','xlsx')"><i class="fa fa-file-excel-o" aria-hidden="true"></i> EXCEL</button>       
        </div>
      </div>      
    </div>    
  </div>
</div>


  <!-- Modal  -->
  <div class="modal fade" id="myModalGenerandoReporte" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title text-center">Generando Reporte!</h4>
        </div>
        <div class="modal-body text-center">
          <img src="../../resources/imagen/public/loading.gif" ng-show="imagencargandovisible">
          <span ng-show="!imagencargandovisible">{{mensajeimagencargandovisible}}</span>
        </div>
      </div>
    </div>
  </div>