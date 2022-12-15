import java.util.Map;

public class WeatherFact {
    private Integer obs_time;
    private Integer uptime;
    private Integer temp;
    private Integer feels_like;
    private String icon;
    private String condition;
    private Double cloudness;
    private Integer prec_type;
    private Integer prec_prob;
    private Integer prec_strength;
    private Boolean is_thunder;
    private Integer wind_speed;
    private String wind_dir;
    private Integer pressure_mm;
    private Integer pressure_pa;
    private Integer humidity;
    private String daytime;
    private Boolean polar;
    private String season;
    private String source;
    private Map<String, Integer> accum_prec;
    private Double soil_moisture;
    private Integer soil_temp;
    private Integer uv_index;
    private Double wind_gust;

    public WeatherFact(Integer obs_time, Integer uptime, Integer temp, Integer feels_like, String icon, String condition,
                       Double cloudness, Integer prec_type, Integer prec_prob, Integer prec_strength, Boolean is_thunder,
                       Integer wind_speed, String wind_dir, Integer pressure_mm, Integer pressure_pa, Integer humidity,
                       String daytime, Boolean polar, String season, String source, Map<String, Integer> accum_prec,
                       Double soil_moisture, Integer soil_temp, Integer uv_index, Double wind_gust) {
        this.obs_time = obs_time;
        this.uptime = uptime;
        this.temp = temp;
        this.feels_like = feels_like;
        this.icon = icon;
        this.condition = condition;
        this.cloudness = cloudness;
        this.prec_type = prec_type;
        this.prec_prob = prec_prob;
        this.prec_strength = prec_strength;
        this.is_thunder = is_thunder;
        this.wind_speed = wind_speed;
        this.wind_dir = wind_dir;
        this.pressure_mm = pressure_mm;
        this.pressure_pa = pressure_pa;
        this.humidity = humidity;
        this.daytime = daytime;
        this.polar = polar;
        this.season = season;
        this.source = source;
        this.accum_prec = accum_prec;
        this.soil_moisture = soil_moisture;
        this.soil_temp = soil_temp;
        this.uv_index = uv_index;
        this.wind_gust = wind_gust;
    }


    public Integer getObs_time() {
        return obs_time;
    }

    public Integer getUptime() {
        return uptime;
    }

    public Integer getTemp() {
        return temp;
    }

    public Integer getFeels_like() {
        return feels_like;
    }

    public String getIcon() {
        return icon;
    }

    public String getCondition() {
        return condition;
    }

    public Double getCloudness() {
        return cloudness;
    }

    public Integer getPrec_type() {
        return prec_type;
    }

    public Integer getPrec_prob() {
        return prec_prob;
    }

    public Integer getPrec_strength() {
        return prec_strength;
    }

    public Boolean getIs_thunder() {
        return is_thunder;
    }

    public Integer getWind_speed() {
        return wind_speed;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public Integer getPressure_mm() {
        return pressure_mm;
    }

    public Integer getPressure_pa() {
        return pressure_pa;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public String getDaytime() {
        return daytime;
    }

    public Boolean getPolar() {
        return polar;
    }

    public String getSeason() {
        return season;
    }

    public String getSource() {
        return source;
    }

    public Map<String, Integer> getAccum_prec() {
        return accum_prec;
    }

    public Double getSoil_moisture() {
        return soil_moisture;
    }

    public Integer getSoil_temp() {
        return soil_temp;
    }

    public Integer getUv_index() {
        return uv_index;
    }

    public Double getWind_gust() {
        return wind_gust;
    }

    public WeatherFact() {
    }
}
