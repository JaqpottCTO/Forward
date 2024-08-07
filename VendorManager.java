package com.blerdU.rootworkapp;

public class VendorManager {
    private List<Vendor> vendors;
    private List<Event> events;

    public VendorManager() {
        this.vendors = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public void addVendor(Vendor vendor) {
        // Add vendor to vendors list
        vendors.add(vendor);
    }

    public void removeVendor(String vendorId) {
        // Remove vendor from vendors list
        vendors.removeIf(v -> v.getVendorId().equals(vendorId));
    }

    public Vendor getVendorDetails(String vendorId) {
        // Return vendor details by vendorId
        for (Vendor vendor : vendors) {
            if (vendor.getVendorId().equals(vendorId)) {
                return vendor;
            }
        }
        return null;
    }
}
