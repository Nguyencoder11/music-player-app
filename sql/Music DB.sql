CREATE TABLE `users` (
  `user_id` uuid PRIMARY KEY NOT NULL,
  `username` varchar(50) UNIQUE NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `full_name` varchar(100),
  `avatar_url` varchar(255),
  `birth_date` date,
  `gender` enum(male,female,other),
  `country` varchar(50),
  `language_preference` varchar(10),
  `last_login` timestamp,
  `created_at` timestamp NOT NULL DEFAULT (now()),
  `updated_at` timestamp NOT NULL DEFAULT (now()),
  `is_premium` bool DEFAULT false,
  `premium_expiry` timestamp,
  `active_status` enum(active,suspended,banned) DEFAULT 'active'
);

CREATE TABLE `artists` (
  `artist_id` uuid PRIMARY KEY NOT NULL,
  `user_id` uuid NOT NULL,
  `name` varchar(20) NOT NULL,
  `bio` text,
  `avatar_url` varchar(255),
  `cover_image_url` varchar(255),
  `website_url` varchar(255),
  `country` varchar(50),
  `follower_count` bigint DEFAULT 0,
  `like_count` bigint DEFAULT 0,
  `created_at` timestamp DEFAULT (now()),
  `updated_at` timestamp DEFAULT (now()),
  `status` enum(active,archived) DEFAULT 'active'
);

CREATE TABLE `genres` (
  `genre_id` uuid PRIMARY KEY NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` text,
  `parent_genre_id` uuid,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `albums` (
  `album_id` uuid PRIMARY KEY NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text,
  `artist_id` uuid,
  `genre_id` uuid,
  `released_date` date,
  `cover_image_url` varchar(255),
  `total_tracks` integer DEFAULT 0,
  `total_duration` integer DEFAULT 0,
  `created_at` timestamp DEFAULT (now()),
  `updated_at` timestamp DEFAULT (now()),
  `status` enum(published,draft,archived) DEFAULT 'published'
);

CREATE TABLE `songs` (
  `song_id` uuid PRIMARY KEY NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` text,
  `duration` integer NOT NULL,
  `release_date` date,
  `language` varchar(10),
  `bpm` integer,
  `lyrics` text,
  `stream_url` varchar(255) NOT NULL,
  `cover_image_url` varchar(255),
  `is_explicit` bool DEFAULT false,
  `is_premium` bool DEFAULT false,
  `listening_count` bigint DEFAULT 0,
  `created_at` timestamp DEFAULT (now()),
  `updated_at` timestamp DEFAULT (now()),
  `song_status` enum(published,draft,archived) DEFAULT 'published'
);

CREATE TABLE `playlists` (
  `playlist_id` uuid PRIMARY KEY NOT NULL,
  `user_id` uuid NOT NULL,
  `title` varchar(50) NOT NULL,
  `description` text,
  `cover_image_url` byte,
  `is_public` bool DEFAULT true,
  `is_collaborative` bool DEFAULT false,
  `total_tracks` integer DEFAULT 0,
  `total_duration` integer DEFAULT 0,
  `follower_count` bigint DEFAULT 0,
  `like_count` bigint DEFAULT 0,
  `created_at` timestamp DEFAULT (now()),
  `updated_at` timestamp DEFAULT (now()),
  `created_by` uuid,
  `updated_by` uuid
);

CREATE TABLE `song_artist` (
  `song_id` uuid NOT NULL,
  `artist_id` uuid NOT NULL,
  `role` enum(main,featured,producer) DEFAULT 'main',
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `song_genres` (
  `song_id` uuid NOT NULL,
  `genre_id` uuid NOT NULL,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `album_songs` (
  `album_id` uuid NOT NULL,
  `song_id` uuid NOT NULL,
  `track_number` integer NOT NULL,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `playlist_songs` (
  `playlist_id` uuid NOT NULL,
  `song_id` uuid NOT NULL,
  `position` integer NOT NULL,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `listening_history` (
  `history_id` uuid PRIMARY KEY NOT NULL,
  `user_id` uuid NOT NULL,
  `song_id` uuid NOT NULL,
  `listened_at` timestamp NOT NULL DEFAULT (now()),
  `duration_listened` integer
);

CREATE TABLE `likes` (
  `like_id` uuid PRIMARY KEY NOT NULL,
  `user_id` uuid NOT NULL,
  `entity_type` enum(song,album,playlist) NOT NULL,
  `entity_id` uuid NOT NULL,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `follows` (
  `follower_id` uuid NOT NULL,
  `followed_id` uuid NOT NULL,
  `follow_type` enum(user,artist) NOT NULL,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `play_queue` (
  `queue_id` uuid PRIMARY KEY NOT NULL,
  `user_id` uuid NOT NULL,
  `song_id` uuid NOT NULL,
  `position` integer NOT NULL,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `notifications` (
  `notification_id` uuid PRIMARY KEY NOT NULL,
  `user_id` uuid NOT NULL,
  `message` text NOT NULL,
  `type` enum(new_song,new_album,follow,system) NOT NULL,
  `entity_type` enum(song,album,artist,user),
  `entity_id` uuid,
  `is_read` bool DEFAULT false,
  `created_at` timestamp DEFAULT (now())
);

CREATE TABLE `transactions` (
  `transaction_id` uuid PRIMARY KEY NOT NULL,
  `entity_type` enum(song,album,genre,artist) NOT NULL,
  `entity_id` uuid,
  `field_name` varchar(50) NOT NULL,
  `language` nvarchar(10) NOT NULL,
  `translated_value` text NOT NULL
);

CREATE TABLE `user_preferences` (
  `user_id` uuid NOT NULL,
  `genre_id` uuid NOT NULL,
  `preference_score` float DEFAULT 0,
  `created_at` timestamp DEFAULT (now()),
  `updated_at` timestamp DEFAULT (now())
);

ALTER TABLE `artists` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `genres` ADD FOREIGN KEY (`parent_genre_id`) REFERENCES `genres` (`genre_id`);

ALTER TABLE `albums` ADD FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`);

ALTER TABLE `albums` ADD FOREIGN KEY (`genre_id`) REFERENCES `genres` (`genre_id`);

ALTER TABLE `playlists` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `playlists` ADD FOREIGN KEY (`created_by`) REFERENCES `users` (`user_id`);

ALTER TABLE `playlists` ADD FOREIGN KEY (`updated_by`) REFERENCES `users` (`user_id`);

ALTER TABLE `song_artist` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`);

ALTER TABLE `song_artist` ADD FOREIGN KEY (`artist_id`) REFERENCES `artists` (`artist_id`);

ALTER TABLE `song_genres` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`);

ALTER TABLE `song_genres` ADD FOREIGN KEY (`genre_id`) REFERENCES `genres` (`genre_id`);

ALTER TABLE `album_songs` ADD FOREIGN KEY (`album_id`) REFERENCES `albums` (`album_id`);

ALTER TABLE `album_songs` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`);

ALTER TABLE `playlist_songs` ADD FOREIGN KEY (`playlist_id`) REFERENCES `playlists` (`playlist_id`);

ALTER TABLE `playlist_songs` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`);

ALTER TABLE `listening_history` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `listening_history` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`);

ALTER TABLE `likes` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `follows` ADD FOREIGN KEY (`follower_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `play_queue` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `play_queue` ADD FOREIGN KEY (`song_id`) REFERENCES `songs` (`song_id`);

ALTER TABLE `notifications` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `user_preferences` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `user_preferences` ADD FOREIGN KEY (`genre_id`) REFERENCES `genres` (`genre_id`);
