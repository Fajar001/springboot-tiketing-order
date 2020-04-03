package com.lawencon.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.app.dao.ParkiranDao;
import com.lawencon.app.model.Parkiran;

@Service
@Transactional
public class ParkiranServiceImpl implements ParkiranService{
	
	@Autowired
	@Qualifier("parkiran_repo_hibernate")
	private ParkiranDao parkirDao;
	
	@Autowired
	private UserService userService;
	
	@Override
	public String insertKendaraan(Parkiran kendaraan, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			if (validKendaraanCheckIn(kendaraan) == true) {
				return parkirDao.insertKendaraan(kendaraan, user, pass);
			} else {
				return "Gagal insert kendaraan";
			}
		} else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
	}

	@Override
	public Boolean validKendaraanCheckIn(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		Parkiran ken2 = null;
		
		try {
			ken2 =  parkirDao.validKendaraanCheckIn(kendaraan); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ken2 != null) {
			if (kendaraan.getNoPlat().replaceAll("\\s+", "").toLowerCase().substring(0, 1).equals("b")) {
				try {
					Integer.parseInt(kendaraan.getNoPlat().substring(1, 5));
					if (kendaraan.getNoPlat().substring(1, 5).length() <= 4
							&& kendaraan.getNoPlat().substring(1, 5).length() >= 1) {
						try {
							Integer.parseInt(kendaraan.getNoPlat().substring(5, 8));
							return false;
						} catch (Exception e) {
							if (ken2.getNoPlat().toLowerCase().equals(kendaraan.getNoPlat().toLowerCase())
									&& ken2.getTanggalMasuk().equals(kendaraan.getTanggalMasuk())) {
								return false;
							} else {
								return true;
							}
						}
					} else {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			} else {
				return false;
			}

		} else {
			return true;
		}
	}

	@Override
	public Boolean validKendaraanCheckOut(Parkiran kendaraan) throws Exception {
		// TODO Auto-generated method stub
		Parkiran ken2 = null;
		try {
			ken2 = parkirDao.validKendaraanCheckOut(kendaraan); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (ken2 != null) {
			if (kendaraan.getNoPlat().replaceAll("\\s+", "").toLowerCase().substring(0, 1).equals("b")) {
				try {
					Integer.parseInt(kendaraan.getNoPlat().substring(1, 5));
					if (kendaraan.getNoPlat().substring(1, 5).length() <= 4
							&& kendaraan.getNoPlat().substring(1, 5).length() >= 1) {
						try {
							Integer.parseInt(kendaraan.getNoPlat().substring(5, 8));
							return false;
						} catch (Exception e) {
							if (ken2.getNoPlat().toLowerCase().equals(kendaraan.getNoPlat().toLowerCase())
									&& ken2.getTanggalMasuk().equals(kendaraan.getTanggalMasuk())) {
								return false;
							} else {
								return true;
							}
						}
					} else {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			} else {
				return false;
			}

		} else {
			return true;
		}
	}

	@Override
	public String insertCheckoutKendaraan(Parkiran kendaraan, String user, String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			if (validKendaraanCheckOut(kendaraan) == false) {
				return parkirDao.insertCheckoutKendaraan(kendaraan, user, pass);
			} else {
				return "Kendaraan tidak ada !";
			}
		} else {
			return "WRONG [USERNAME] OR [PASSWORD] !";
		}
		
	}

	@Override
	public List<Parkiran> viewKendaraanCheckIn(String user,String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			return parkirDao.viewKendaraanCheckIn();
		} else {
			return null;
		}
//		return parkirDao.viewKendaraanCheckIn();
	}

	@Override
	public List<Parkiran> viewKendaraanCheckOut(String user,String pass) throws Exception {
		// TODO Auto-generated method stub
		if (userService.validuser(user, pass) == true) {
			return parkirDao.viewKendaraanCheckOut();
		} else {
			return null;
		}	
	}

}
