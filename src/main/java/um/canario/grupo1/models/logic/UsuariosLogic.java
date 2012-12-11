package um.canario.grupo1.models.logic;

import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.UsuarioDao;


public class UsuariosLogic {
    
        UsuarioDao usuarioDao;
 
	public void setStockDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public void save(UsuarioBean usuarioBean){
	//	usuarioDao.save(usuarioBean);
	}
/* 
	public void update(UsuariosDao usuarioDao){
		stockDao.update(stock);
	}
 
	public void delete(UsuariosDao usuarioDao){
		stockDao.delete(stock);
	}
 
	public Stock findByStockCode(UsuariosDao usuarioDao){
		return stockDao.findByStockCode(stockCode);
	}
*/
}
