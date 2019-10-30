package com.vermeg.budget.services.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.budget.entities.ChiffreAffaire;
import com.vermeg.budget.entities.Lot;
import com.vermeg.budget.model.RecapCAProba;
import com.vermeg.budget.model.RecapCATypeCA;
import com.vermeg.budget.repositories.ChiffreAffaireRepository;
import com.vermeg.budget.services.ChiffreAffaireService;

@Service
public class ChiffreAffaireServiceImpl implements ChiffreAffaireService {
	@Autowired
	private ChiffreAffaireRepository chiffreAffaireRepository;

	@Override
	public void save(ChiffreAffaire chiffreAffaire) {

		double result = chiffreAffaire.getLot().getMontantDeDeal() / 12;
		chiffreAffaire.setJanvierWithoutProb(result);
		chiffreAffaire.setFevrierWithoutProb(result);
		chiffreAffaire.setMarsWithoutProb(result);
		chiffreAffaire.setAvrilWithoutProb(result);
		chiffreAffaire.setMaiWithoutProb(result);
		chiffreAffaire.setJuinWithoutProb(result);
		chiffreAffaire.setJuilletWithoutProb(result);
		chiffreAffaire.setAoutWithoutProb(result);
		chiffreAffaire.setSeptemberWithoutProb(result);
		chiffreAffaire.setOctoberWithoutProb(result);
		chiffreAffaire.setNovemberWithoutProb(result);
		chiffreAffaire.setDecemberWithoutProb(result);

		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("##.##", symbols);
		chiffreAffaire.setJanvierWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setFevrierWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite()) / 100)));
		chiffreAffaire.setMarsWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setAvrilWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setMaiWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setJuinWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setJuilletWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setAoutWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setSeptemberWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setOctoberWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setNovemberWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setDecemberWithProb(
				Double.parseDouble(df.format((result * chiffreAffaire.getLot().getProbabilite() ) / 100)));

		double resultWithProb = chiffreAffaire.getJanvierWithProb() + chiffreAffaire.getFevrierWithProb()
				+ chiffreAffaire.getMarsWithProb() + chiffreAffaire.getAvrilWithProb() + chiffreAffaire.getMaiWithProb()
				+ chiffreAffaire.getJuinWithProb() + chiffreAffaire.getJuilletWithProb()
				+ chiffreAffaire.getAoutWithProb() + chiffreAffaire.getSeptemberWithProb()
				+ chiffreAffaire.getOctoberWithProb() + chiffreAffaire.getNovemberWithProb()
				+ chiffreAffaire.getDecemberWithProb();
		double resultWithoutProb = chiffreAffaire.getJanvierWithoutProb() + chiffreAffaire.getFevrierWithoutProb()
		+ chiffreAffaire.getMarsWithoutProb() + chiffreAffaire.getAvrilWithoutProb() + chiffreAffaire.getMaiWithoutProb()
		+ chiffreAffaire.getJuinWithoutProb() + chiffreAffaire.getJuilletWithoutProb()
		+ chiffreAffaire.getAoutWithoutProb() + chiffreAffaire.getSeptemberWithoutProb()
		+ chiffreAffaire.getOctoberWithoutProb() + chiffreAffaire.getNovemberWithoutProb()
		+ chiffreAffaire.getDecemberWithoutProb();
		
		chiffreAffaire.setTotalAvecProbabilite(Double.parseDouble(df.format(resultWithProb)));
		chiffreAffaire.setTotalSansProbabilite(Double.parseDouble(df.format(resultWithoutProb)));
		chiffreAffaireRepository.save(chiffreAffaire);
	}

	@Override
	public void update(ChiffreAffaire chiffreAffaire) {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("##.##", symbols);
		chiffreAffaire.setJanvierWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getJanvierWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setFevrierWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getFevrierWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setMarsWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getMarsWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setAvrilWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getAvrilWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setMaiWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getMaiWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setJuinWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getJuinWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setJuilletWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getJuilletWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setAoutWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getAoutWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setSeptemberWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getSeptemberWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setOctoberWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getOctoberWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setNovemberWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getNovemberWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));
		chiffreAffaire.setDecemberWithProb(
				Double.parseDouble(df.format((chiffreAffaire.getDecemberWithoutProb() * chiffreAffaire.getLot().getProbabilite() ) / 100)));

		double resultWithProb = chiffreAffaire.getJanvierWithProb() + chiffreAffaire.getFevrierWithProb()
				+ chiffreAffaire.getMarsWithProb() + chiffreAffaire.getAvrilWithProb() + chiffreAffaire.getMaiWithProb()
				+ chiffreAffaire.getJuinWithProb() + chiffreAffaire.getJuilletWithProb()
				+ chiffreAffaire.getAoutWithProb() + chiffreAffaire.getSeptemberWithProb()
				+ chiffreAffaire.getOctoberWithProb() + chiffreAffaire.getNovemberWithProb()
				+ chiffreAffaire.getDecemberWithProb();
		double resultWithoutProb = chiffreAffaire.getJanvierWithoutProb() + chiffreAffaire.getFevrierWithoutProb()
		+ chiffreAffaire.getMarsWithoutProb() + chiffreAffaire.getAvrilWithoutProb() + chiffreAffaire.getMaiWithoutProb()
		+ chiffreAffaire.getJuinWithoutProb() + chiffreAffaire.getJuilletWithoutProb()
		+ chiffreAffaire.getAoutWithoutProb() + chiffreAffaire.getSeptemberWithoutProb()
		+ chiffreAffaire.getOctoberWithoutProb() + chiffreAffaire.getNovemberWithoutProb()
		+ chiffreAffaire.getDecemberWithoutProb();
		
		chiffreAffaire.setTotalAvecProbabilite(Double.parseDouble(df.format(resultWithProb)));
		chiffreAffaire.setTotalSansProbabilite(Double.parseDouble(df.format(resultWithoutProb)));
		chiffreAffaireRepository.save(chiffreAffaire);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		chiffreAffaireRepository.deleteById(id);
	}

	@Override
	public List<ChiffreAffaire> findByLot(Lot lot) {
		// TODO Auto-generated method stub
		return chiffreAffaireRepository.findByLot(lot);
	}

	@Override
	public List<RecapCAProba> getRecapCa(String annee) {
		// TODO Auto-generated method stub
		return chiffreAffaireRepository.getRecapCa(annee);
	}

	@Override
	public List<RecapCATypeCA> getRecapTypeCa(String annee) {
		// TODO Auto-generated method stub
		return chiffreAffaireRepository.getRecapTypeCa(annee);
	}

}
