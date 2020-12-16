INSERT INTO roles(id,name) VALUES(1,'ROLE_ADMIN') ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO roles(id,name) VALUES(2,'ROLE_USER') ON CONFLICT DO NOTHING;COMMIT;

INSERT INTO users (id,is_active,  email, name, password, username) VALUES (1, true, 'admin@admin.com', 'Admin Admin','$2a$10$qa4xo/893ezidqnf0o3rouBz9UmeltzK8n8YRwHFRQXQjVi1SohvG', 'admin') ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO users (id,is_active,  email, name, password, username) VALUES (2, true, 'testuser1@testuser.com', 'TestUser1 TestUser1','$2a$10$qa4xo/893ezidqnf0o3rouBz9UmeltzK8n8YRwHFRQXQjVi1SohvG', 'testuser1') ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO users (id,is_active,  email, name, password, username) VALUES (3, true, 'testuser2@testuser.com', 'TestUser2 TestUser2','$2a$10$qa4xo/893ezidqnf0o3rouBz9UmeltzK8n8YRwHFRQXQjVi1SohvG', 'testuser2') ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO users (id,is_active,  email, name, password, username) VALUES (4, true, 'testuser3@testuser.com', 'TestUser3 TestUser3','$2a$10$qa4xo/893ezidqnf0o3rouBz9UmeltzK8n8YRwHFRQXQjVi1SohvG', 'testuser3') ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO users (id,is_active,  email, name, password, username) VALUES (5, true, 'testuser4@testuser.com', 'TestUser4 TestUser4','$2a$10$qa4xo/893ezidqnf0o3rouBz9UmeltzK8n8YRwHFRQXQjVi1SohvG', 'testuser4') ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1) ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2) ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO user_roles (user_id, role_id) VALUES (3, 2) ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO user_roles (user_id, role_id) VALUES (4, 2) ON CONFLICT DO NOTHING;COMMIT;
INSERT INTO user_roles (user_id, role_id) VALUES (5, 2) ON CONFLICT DO NOTHING;COMMIT;