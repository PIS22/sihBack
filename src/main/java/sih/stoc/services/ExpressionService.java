package sih.stoc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.stoc.entities.ExpressionBesoin;
import sih.stoc.repositories.ExpressionRepo;

@Service
public class ExpressionService {
	@Autowired
	private ExpressionRepo eRepo;
	
	public ExpressionBesoin save(ExpressionBesoin obj) {
		int rang=1;
		String num ="EB"+obj.getExo().getCodExo()+"-";
		String debNum=num+"-%";
		if(eRepo.dernier(debNum).equals(null)) {
			rang=eRepo.dernier(debNum).getRang()+1;
		}
		
		for(int i=0; i<6-String.valueOf(rang).length(); i++) {
			num+="0";
		}
		obj.setNumEB(num+String.valueOf(rang));
		obj.setRang(rang);
		return eRepo.save(obj);
	}
	
	

}
