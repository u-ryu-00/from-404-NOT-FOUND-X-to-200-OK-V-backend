package kr.megaptera.F4T2.models;

public class KakaoProfile {
    public Long id;
    public String connected_at;
    public Properties properties;
    public KakaoAccount kakao_account;

    public KakaoProfile() {
    }

    public KakaoProfile(Long id, String connected_at, Properties properties, KakaoAccount kakao_account) {
        this.id = id;
        this.connected_at = connected_at;
        this.properties = properties;
        this.kakao_account = kakao_account;
    }

    public Long getId() {
        return id;
    }

    public String getConnected_at() {
        return connected_at;
    }

    public Properties getProperties() {
        return properties;
    }

    public KakaoAccount getKakao_account() {
        return kakao_account;
    }

    public class Properties {
        public String nickname;
        public String profile_image;
        public String thumbnail_image;

        public Properties() {
        }

        public Properties(String nickname, String profile_image, String thumbnail_image) {
            this.nickname = nickname;
            this.profile_image = profile_image;
            this.thumbnail_image = thumbnail_image;
        }

        public String getNickname() {
            return nickname;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public String getThumbnail_image() {
            return thumbnail_image;
        }
    }

    public class KakaoAccount {
        public Boolean profile_nickname_needs_agreement;
        public Boolean profile_image_needs_agreement;
        public Profile profile;
        public Boolean has_email;
        public Boolean email_needs_agreement;
        public Boolean is_email_valid;
        public Boolean is_email_verified;
        public String email;

        public KakaoAccount() {
        }

        public KakaoAccount(Boolean profile_nickname_needs_agreement, Boolean profile_image_needs_agreement, Profile profile, Boolean has_email, Boolean email_needs_agreement, Boolean is_email_valid, Boolean is_email_verified, String email) {
            this.profile_nickname_needs_agreement = profile_nickname_needs_agreement;
            this.profile_image_needs_agreement = profile_image_needs_agreement;
            this.profile = profile;
            this.has_email = has_email;
            this.email_needs_agreement = email_needs_agreement;
            this.is_email_valid = is_email_valid;
            this.is_email_verified = is_email_verified;
            this.email = email;
        }

        public Boolean getProfile_nickname_needs_agreement() {
            return profile_nickname_needs_agreement;
        }

        public Boolean getProfile_image_needs_agreement() {
            return profile_image_needs_agreement;
        }

        public Profile getProfile() {
            return profile;
        }

        public Boolean getHas_email() {
            return has_email;
        }

        public Boolean getEmail_needs_agreement() {
            return email_needs_agreement;
        }

        public Boolean getIs_email_valid() {
            return is_email_valid;
        }

        public Boolean getIs_email_verified() {
            return is_email_verified;
        }

        public String getEmail() {
            return email;
        }

        public class Profile {
            public String nickname;
            public String thumbnail_image_url;
            public String profile_image_url;
            public Boolean is_default_image;

            public Profile() {
            }

            public Profile(String nickname, String thumbnail_image_url, String profile_image_url, Boolean is_default_image) {
                this.nickname = nickname;
                this.thumbnail_image_url = thumbnail_image_url;
                this.profile_image_url = profile_image_url;
                this.is_default_image = is_default_image;
            }

            public String getNickname() {
                return nickname;
            }

            public String getThumbnail_image_url() {
                return thumbnail_image_url;
            }

            public String getProfile_image_url() {
                return profile_image_url;
            }

            public Boolean getIs_default_image() {
                return is_default_image;
            }
        }
    }

}
