package um.canario.grupo1.models.logic;

import um.canario.grupo1.models.beans.UsuariosBean;
import um.canario.grupo1.models.dao.UsuariosDao;


public class UsuariosLogic {
    
        UsuariosDao usuarioDao;
 
	public void setStockDao(UsuariosDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public void save(UsuariosBean usuarioBean){
		usuarioDao.save(usuarioBean);
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
