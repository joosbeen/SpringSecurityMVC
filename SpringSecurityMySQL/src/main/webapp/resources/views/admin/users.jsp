
  <h2 class="text-center">USUARIOS</h2>
  <p></p>

  <!-- Trigger the modal with a button -->
<button type="button" class="btn btn-success btn-lg right" data-toggle="modal" data-target="#myModal" ng-click="f_action_add_update('add',null);">Nuevo Usurio</button>
  <p></p>
  <table class="table table-bordered table-hover" style="background: white;">
    <thead>
      <tr class="info">
        <th>USERNAME</th>
        <th>NOMBRE</th>
        <th>APELLIDOS</th>
        <th>CORREO</th>
        <th>ESTADO</th>
        <th>ACCIONES</th>
      </tr>
    </thead>
    <tbody>
      <tr ng-repeat="x in usuarios">
        <td>{{ x.username }}</td>
        <td>{{ x.nombre }}</td>
        <td>{{ x.apellidos }}</td>
        <td>{{ x.correo_ELECTRONICO_PPAL }}</td>
        <td>
          <button type="button" data-toggle="tooltip" data-placement="top" title="Click, Cambiar Estado!" class="btn {{estado_color_boton(x.enabled);}}" ng-click="status_usuarios(x);">{{estado_boolean_a_string(x.enabled);}}</button>
        </td>
        <td>
          <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal" ng-click="f_action_add_update('update', x);">Editar</button>
        </td>
      </tr>
    </tbody>
  </table>


<!-- Modal Editar - Agregar Usuario -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <form name="formusuario">
        <div class="modal-header ">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title text-center">
            <strong>{{ tituloModalUsuario }}</strong>   
              <div class="alert alert-danger" ng-show="alert_visible">
                <strong> Error: </strong>{{mensaje_campo_invalido}}
              </div>    
          </h4>
        </div>
        <div class="modal-body">

          <div class="row">
            <div class="col-md-6">
                              <div class="form-group">
                  <label for="username">Nombre de Usuario:</label>
                  <input type="text" class="form-control" id="username" ng-model="usuario.username" required>
                </div>
            </div>
            <div class="col-md-6">
                              <div class="form-group">
                  <label for="username">Contase&ntilde;a:</label>
                  <input type="text" class="form-control" id="username" ng-model="usuario.password" minlength="6" maxlength="12" required>
                </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="checkbox">
                <label><input type="checkbox" ng-model="usuario.enabled"> <strong>Estado</strong>(Inacativo/activo)  </label>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" ng-model="usuario.nombre" required>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label for="nombre">Apellidos:</label>
                <input type="text" class="form-control" id="nombre" ng-model="usuario.apellidos" required>
              </div>              
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label for="nombre">Fecha Nacimiento:</label>   
                <div class="row">
                  <div class="col-md-6">
                    <input type="text" name="" value="{{usuario.fecha_NACIMIENTO}}" disabled="">
                  </div>
                  <div class="col-md-6">           
                    <input type="date" class="form-control" id="fecha_nac" ng-change="guardar_fecha_nacimiento();" ng-model="fecha_NACIMIENTO_dos" value="2017-06-01" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" required>
                  </div>
                </div> 
              </div>                           
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Sexo:
                </label>
                  <div class="row text-center">
                    <div class="col-md-6">
                       <div class="radio">
                        <input type="radio" name="optradio"  ng-click="sexo_usuario_define('H');" checked>Hombre
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="radio">
                        <input type="radio" name="optradio"  ng-click="sexo_usuario_define('M');">Mujer
                      </div>
                    </div>
                  </div>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                  <label for="huso_HORARIO">Huso Horario:</label>
                  <input type="text" class="form-control" id="huso_HORARIO" ng-model="usuario.huso_HORARIO" required>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                  <label for="correo_ELECTRONICO_PPAL">Email:</label>
                  <input type="email" class="form-control" id="correo_ELECTRONICO_PPAL" ng-model="usuario.correo_ELECTRONICO_PPAL" required>
                </div>
            </div>
            <div class="col-md-6">
              <div class="checkbox">
                <label><input type="checkbox" ng-model="usuario.tracking"><strong>Tracking</strong></label>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label for="sel1">ROLE:</label>
                <select ng-model="role">
                  <option ng-repeat="x in authoritys" value="{{x.description}}" ng-click="asignar_role_usuario(x)">{{x.authority}}</option>
                </select>
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label for="comment">Descripcion:</label>
                <textarea class="form-control" rows="2" id="comment">{{role}}</textarea>
              </div>
            </div>
          </div>

        </div>
        <div class="modal-footer">
          <div class="row">
            <div class="col-md-8">
              <button type="button" class="btn btn-info btn-block" ng-click="registrar_actualizar_usuario();">Guardar</button>              
            </div>
            <div class="col-md-4">
              <button type="button" class="btn btn-danger btn-block" data-dismiss="modal">Cerrar</button>
            </div>
          </div>
        </div>
      </form> 
    </div>

  </div>
</div>


  <!-- Modal Aviso-->
  <div class="modal fade" id="myModalMensajeAlert" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header"  style="background: {{ mensajeModalErrorBackground }};">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><h3 class="text-center"> {{ mensajeModalErrorTitulo }} </h3></h4>
        </div>
        <div class="modal-body">
          <p>{{ mensajeModalErrorMensaje }}</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
