/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package um.canario.grupo1.services;

import um.canario.grupo1.models.beans.UsuariosBean;

/**
 *
 * @author Borja Abad
 */
public interface UsuarioBo {
        void save(Object objeto);
	void update(Object objeto);
	void delete(Object objeto);
	Object findByStockCode(String id);
}
