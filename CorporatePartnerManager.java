import java.util.ArrayList;
import java.util.List;

public class CorporatePartnerManager {
    private List<CorporatePartner> corporatePartners;

    public CorporatePartnerManager() {
        this.corporatePartners = new ArrayList<>();
    }

    public void addCorporatePartner(CorporatePartner partner) {
        this.corporatePartners.add(partner);
    }

    public void updateCorporatePartner(CorporatePartner partner) {
        for (int i = 0; i < corporatePartners.size(); i++) {
            if (corporatePartners.get(i).getId().equals(partner.getId())) {
                corporatePartners.set(i, partner);
                return;
            }
        }
    }

    public void deleteCorporatePartner(String partnerId) {
        corporatePartners.removeIf(partner -> partner.getId().equals(partnerId));
    }

    public CorporatePartner getCorporatePartnerById(String partnerId) {
        for (CorporatePartner partner : corporatePartners) {
            if (partner.getId().equals(partnerId)) {
                return partner;
            }
        }
        return null;
    }

    public List<CorporatePartner> getAllCorporatePartners() {
        return corporatePartners;
    }
}
