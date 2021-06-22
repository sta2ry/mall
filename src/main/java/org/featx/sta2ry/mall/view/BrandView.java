package org.featx.sta2ry.mall.view;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.featx.spec.model.BaseUnified;
import org.featx.sta2ry.lyrae.model.BrandShow;

import java.time.LocalDate;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class BrandView extends BaseUnified {

    private String target;

    private LocalDate since;

    private String founder;

    private String nation;

    private String origin;

    private String description;

    public static BrandView from(BrandShow brandShow) {
        BrandView brandView = new BrandView();
        brandView.setTarget(brandShow.getTarget());
        brandView.setSince(brandShow.getSince());
        brandView.setFounder(brandShow.getFounder());
        brandView.setNation(brandShow.getNation());
        brandView.setOrigin(brandShow.getOrigin());
        brandView.setDescription(brandShow.getDescription());
        return brandView;
    }
}
