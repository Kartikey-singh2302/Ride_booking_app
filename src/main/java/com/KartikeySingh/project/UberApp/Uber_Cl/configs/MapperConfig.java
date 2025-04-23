package com.KartikeySingh.project.UberApp.Uber_Cl.configs;
import com.KartikeySingh.project.UberApp.Uber_Cl.dto.PointDTO;
import com.KartikeySingh.project.UberApp.Uber_Cl.utils.GeometryUtil;
import org.locationtech.jts.geom.Point;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;
@Configuration

public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.typeMap(PointDTO.class, Point.class).setConverter(context->
        {PointDTO pointDTO=context.getSource();
            return GeometryUtil.createPoint(pointDTO);
        });

        mapper.typeMap(Point.class,PointDTO.class).setConverter(context->{
            Point point=context.getSource();
            double coordinates[]={
                    point.getX(),
                    point.getY()
            };
            return new PointDTO(coordinates);
        });

      return mapper;
    }
}
