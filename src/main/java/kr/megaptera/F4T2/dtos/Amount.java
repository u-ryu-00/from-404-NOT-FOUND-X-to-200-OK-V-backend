package kr.megaptera.F4T2.dtos;

public class Amount {
    private int total;
    private int tax_free;
    private int vat;
    private int point;
    private int discount;
    private int green_deposit;

    public Amount() {
    }

    public Amount(int total, int tax_free, int vat, int point, int discount, int green_deposit) {
        this.total = total;
        this.tax_free = tax_free;
        this.vat = vat;
        this.point = point;
        this.discount = discount;
        this.green_deposit = green_deposit;
    }

    public int getTotal() {
        return total;
    }

    public int getTax_free() {
        return tax_free;
    }

    public int getVat() {
        return vat;
    }

    public int getPoint() {
        return point;
    }

    public int getDiscount() {
        return discount;
    }

    public int getGreen_deposit() {
        return green_deposit;
    }
}
